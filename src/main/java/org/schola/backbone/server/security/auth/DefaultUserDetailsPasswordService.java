package org.schola.backbone.server.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserDetailsPasswordService implements UserDetailsPasswordService {

    @Autowired
    private CompromisedPasswordCheckerWithRegex checker;

    @Override
    public UserDetails updatePassword(UserDetails user, String password) {

        assert checker.check(password).isCompromised();

        return User.withUserDetails(user).password(password).build();
    }
}