package org.schola.backbone.server.data.service;

import org.schola.backbone.server.data.service.resolver.AccountInputResolver;
import org.schola.backbone.server.data.model.Account;
import org.schola.backbone.server.data.repository.mysql.JpaAccountRepository;
import org.schola.backbone.server.data.repository.redis.RedisAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class AccountDataService {

    private final ApplicationContext context;

    private final RedisAccountRepository redis;
    private final JpaAccountRepository jpa;

    @Autowired
    public AccountDataService(ApplicationContext context, RedisAccountRepository redis, JpaAccountRepository jpa) {
        this.context = context;
        this.redis = redis;
        this.jpa = jpa;
    }

    public <T> Account get(Class<? extends AccountInputResolver<T>> clazz, T value) {
        AccountInputResolver<T> resolver = context.getBean(clazz);
        return resolver.fetch(value);
    }

    public void persist(Account account) {
        jpa.save(account);
    }

    public void save(Account account) {
        persist(account);
        put(account);
    }

    public void put(Account account) {
        redis.save(account);
    }

    public <T> void delete(Class<? extends AccountInputResolver<T>> clazz, T value) {
        AccountInputResolver<T> resolver = context.getBean(clazz);
        resolver.purge(value);
    }
}