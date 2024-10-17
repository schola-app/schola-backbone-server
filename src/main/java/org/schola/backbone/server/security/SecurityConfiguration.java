package org.schola.backbone.server.security;

import org.schola.backbone.server.security.auth.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private CompromisedPasswordCheckerFactory passwordCheckerFactory;

    @Bean
    public SecurityFilterChain chain(HttpSecurity security) throws Exception {

        final DaoAuthenticationProvider provider = authenticationProvider();

        security.authenticationProvider(provider);
        return security.build();
    }

    public DaoAuthenticationProvider authenticationProvider() {
        final DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        final UserCache userCache = new DefaultUserCache();
        final UserDetailsPasswordService passwordService = new DefaultUserDetailsPasswordService();
        final UserDetailsService userDetailsService = new DefaultUserDetailsService();
        final PasswordEncoder passwordEncoder = this.passwordEncoder();
        final CompromisedPasswordChecker passwordChecker = this.passwordChecker();

        provider.setUserCache(userCache);
        provider.setUserDetailsPasswordService(passwordService);
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        provider.setCompromisedPasswordChecker(passwordChecker);

        return provider;
    }

    @Bean
    public RoleHierarchy hierarchy() {
        return RoleHierarchyImpl.withDefaultRolePrefix()
                .role("DEVELOPER").implies("ADMIN")
                .role("ADMIN").implies("TEACHER")
                .role("TEACHER").implies("STUDENT")
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CompromisedPasswordCheckerWithRegex passwordChecker() {
        return passwordCheckerFactory.get();
    }
}