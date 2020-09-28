package com.cczu.ratelimiter;

import com.cczu.ratelimiter.alg.RateLimitAlg;
import com.cczu.ratelimiter.rule.ApiLimit;
import com.cczu.ratelimiter.rule.RateLimiterRule;
import com.cczu.ratelimiter.rule.RuleConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jianzhen.yin
 * @date 2020/9/22
 */
public class RateLimiter {
    private static final Logger log = LoggerFactory.getLogger(RateLimiter.class);
    private Map<String, RateLimitAlg> counters = new ConcurrentHashMap<>();
    private RateLimiterRule rule;
    public RateLimiter(){
        InputStream in = null;
        RuleConfig ruleConfig = null;
        try {
            in = this.getClass().getResourceAsStream("/ratelimiter-rule.yaml");
            if (in != null){
                Yaml yaml = new Yaml();
                ruleConfig = yaml.loadAs(in, RuleConfig.class);
            }
        } finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    log.error("close file error",e);
                }
            }
        }
        // 将限流规则构建成支持快速查找的数据结构RateLimitRule
        this.rule = new RateLimiterRule(ruleConfig);
    }

    public boolean limit(String appId,String url){
        ApiLimit apiLimit = rule.getLimit(appId, url);
        if (apiLimit == null){
            return true;
        }
        String countKey = appId + ":" + apiLimit.getApi();
        RateLimitAlg rateLimitAlg = counters.get(countKey);
        if (rateLimitAlg == null){
            RateLimitAlg newRateLimitAlg = new RateLimitAlg(apiLimit.getLimit());
            rateLimitAlg = counters.putIfAbsent(countKey,newRateLimitAlg);
            if (rateLimitAlg == null){
                rateLimitAlg = newRateLimitAlg;
            }
        }
        return rateLimitAlg.tryAcquire();
    }

}
