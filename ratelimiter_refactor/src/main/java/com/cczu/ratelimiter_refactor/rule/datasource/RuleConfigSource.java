package com.cczu.ratelimiter_refactor.rule.datasource;

import com.cczu.ratelimiter_refactor.rule.RuleConfig;

/**
 * @author jianzhen.yin
 * @date 2020/9/22
 */
public interface RuleConfigSource {
    RuleConfig load();
}
