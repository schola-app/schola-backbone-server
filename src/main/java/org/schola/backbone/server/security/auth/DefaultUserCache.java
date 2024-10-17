package org.schola.backbone.server.security.auth;

import org.schola.backbone.server.data.model.Account;
import org.schola.backbone.server.data.service.AccountDataService;
import org.schola.backbone.server.data.service.resolver.AccountInputResolvers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;

public class DefaultUserCache implements UserCache {

    @Autowired
    private AccountDataService service;

    @Override
    public UserDetails getUserFromCache(String username) {
        return service.get(AccountInputResolvers.USERNAME, username);
    }

    @Override
    public void putUserInCache(UserDetails user) {
        final Account account = (Account) user;
        service.save(account);
    }

    @Override
    public void removeUserFromCache(String username) {
        service.delete(AccountInputResolvers.USERNAME, username);
    }
}