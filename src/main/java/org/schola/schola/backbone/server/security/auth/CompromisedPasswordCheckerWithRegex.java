package org.schola.schola.backbone.server.security.auth;

import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.authentication.password.CompromisedPasswordDecision;

import java.util.regex.Pattern;

@Data
public abstract class CompromisedPasswordCheckerWithRegex implements CompromisedPasswordChecker {

    private final Pattern pattern;

    public CompromisedPasswordCheckerWithRegex(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    @NotNull
    @Override
    public CompromisedPasswordDecision check(String password) {
        final boolean matches = this.getPattern().matcher(password).matches();
        return new CompromisedPasswordDecision(matches);
    }
}