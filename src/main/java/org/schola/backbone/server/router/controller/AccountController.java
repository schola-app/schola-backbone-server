package org.schola.backbone.server.router.controller;

import org.schola.backbone.server.data.model.Account;
import org.schola.backbone.server.data.service.AccountDataService;
import org.schola.backbone.server.data.service.resolver.AccountInputResolvers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    private final AccountDataService service;

    @Autowired
    public AccountController(AccountDataService service) {
        this.service = service;
    }

    @GetMapping // TODO
    public ResponseEntity<Account> getAccount() {
        final Account account = service.get(AccountInputResolvers.ID, 1L);
        return ResponseEntity.ok(account);
    }
}