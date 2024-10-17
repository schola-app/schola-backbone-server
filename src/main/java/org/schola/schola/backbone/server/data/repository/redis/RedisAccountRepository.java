package org.schola.schola.backbone.server.data.repository.redis;

import org.schola.schola.backbone.server.data.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface RedisAccountRepository extends CrudRepository<Account, Long> { }
