package org.schola.backbone.server.router.controller;

import org.schola.backbone.server.data.model.Account;
import org.schola.backbone.server.data.service.AccountDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    private AccountDataService service;

    @Autowired
    public AccountController(AccountDataService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Account> getAccount() {

    }
}