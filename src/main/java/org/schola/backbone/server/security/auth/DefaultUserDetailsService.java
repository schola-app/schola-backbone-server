package org.schola.backbone.server.security.auth;

import org.schola.backbone.server.data.service.AccountDataService;
import org.schola.backbone.server.data.service.resolver.AccountInputResolvers;
import org.schola.backbone.server.data.model.Account;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserDetailsService implements UserDetailsService {

    private AccountDataService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = service.get(AccountInputResolvers.USERNAME, username);
        if (account == null)
            throw new UsernameNotFoundException("User not found");
        return account;
    }
}