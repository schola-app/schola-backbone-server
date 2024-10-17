package org.schola.backbone.server.data.service.resolver;

import org.schola.backbone.server.common.InputResolver;
import org.schola.backbone.server.data.model.Account;
import org.schola.backbone.server.data.repository.mysql.JpaAccountRepository;
import org.schola.backbone.server.data.repository.redis.RedisAccountRepository;

public abstract class AccountInputResolver<T> implements InputResolver<Account, T> {

    private final JpaAccountRepository jpa;
    private final RedisAccountRepository redis;

    public AccountInputResolver(JpaAccountRepository jpa, RedisAccountRepository redis) {
        this.jpa = jpa;
        this.redis = redis;
    }

    public JpaAccountRepository getJpa() {
        return jpa;
    }

    public RedisAccountRepository getRedis() {
        return redis;
    }
}
