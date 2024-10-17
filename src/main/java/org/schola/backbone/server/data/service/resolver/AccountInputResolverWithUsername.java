package org.schola.backbone.server.data.service.resolver;

import org.schola.backbone.server.data.model.Account;
import org.schola.backbone.server.data.repository.mysql.JpaAccountRepository;
import org.schola.backbone.server.data.repository.redis.RedisAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountInputResolverWithUsername extends AccountInputResolver<String> {

    @Autowired
    public AccountInputResolverWithUsername(JpaAccountRepository jpa, RedisAccountRepository redis) {
        super(jpa, redis);
    }

    @Override
    public Account fetch(String param) {
        return this.getRedis()
                .findByUsername(param)
                .orElse(
                        this.getJpa()
                                .findByUsername(param)
                                .orElse(null)
                );
    }

    @Override
    public void purge(String param) {
        final Account account = this.fetch(param);
        this.getRedis()
                .delete(account);
        this.getJpa()
                .delete(account);
    }
}
