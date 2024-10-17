package org.schola.backbone.server.data.service.resolver;

import org.schola.backbone.server.data.model.Account;
import org.schola.backbone.server.data.repository.mysql.JpaAccountRepository;
import org.schola.backbone.server.data.repository.redis.RedisAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountInputResolverWithIdentifier extends AccountInputResolver<Long> {

    @Autowired
    public AccountInputResolverWithIdentifier(JpaAccountRepository jpa, RedisAccountRepository redis) {
        super(jpa, redis);
    }

    @Override
    public Account fetch(Long param) {
        return this.getRedis()
                .findById(param)
                .orElse(
                        this.getJpa()
                                .findById(param)
                                .orElse(null)
                );
    }

    @Override
    public void purge(Long param) {
        final Account account = this.fetch(param);
        this.getRedis()
                .delete(account);
        this.getJpa()
                .delete(account);
    }
}
