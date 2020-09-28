package com.cczu.ratelimiter_refactor.alg;



/**
 * @author jianzhen.yin
 * @date 2020/9/22
 */
public interface RateLimitAlg {
    boolean tryAcquire();
}
