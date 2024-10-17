package org.schola.schola.backbone.server.security.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserDetailsPasswordService implements UserDetailsPasswordService {

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        return null;
    }
}