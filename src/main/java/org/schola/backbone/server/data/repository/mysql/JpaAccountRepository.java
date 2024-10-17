package org.schola.backbone.server.data.repository.mysql;

import org.schola.backbone.server.data.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaAccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByUsername(String username);

}
