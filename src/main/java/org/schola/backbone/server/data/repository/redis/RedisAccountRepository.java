package org.schola.backbone.server.data.repository.redis;

import org.schola.backbone.server.data.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RedisAccountRepository extends CrudRepository<Account, Long> {

    Optional<Account> findByUsername(String username);

}
