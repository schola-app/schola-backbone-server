package org.schola.schola.backbone.server.security;

import org.schola.schola.backbone.server.security.auth.CompromisedPasswordCheckerConfiguration;
import org.schola.schola.backbone.server.security.auth.CompromisedPasswordCheckerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableConfigurationProperties(CompromisedPasswordCheckerConfiguration.class)
public class SecurityConfiguration {

    @Autowired
    private CompromisedPasswordCheckerFactory passwordCheckerFactory;

    @Bean
    public SecurityFilterChain chain(HttpSecurity security) throws Exception {
        return security.build();
    }

    public DaoAuthenticationProvider authenticationProvider() {
        final DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        final PasswordEncoder passwordEncoder = this.passwordEncoder();
        final CompromisedPasswordChecker passwordChecker = this.passwordChecker();

        provider.setPasswordEncoder(passwordEncoder);
        provider.setCompromisedPasswordChecker(passwordChecker);

        return provider;
    }

    @Bean
    public RoleHierarchy roleHierarchy() {
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

    public CompromisedPasswordChecker passwordChecker() {
        return passwordCheckerFactory.get();
    }
}