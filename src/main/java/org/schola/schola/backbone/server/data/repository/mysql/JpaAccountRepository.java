package org.schola.schola.backbone.server.data.repository.mysql;

import org.schola.schola.backbone.server.data.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAccountRepository extends JpaRepository<Account, Long> { }
