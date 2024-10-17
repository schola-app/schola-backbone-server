package org.schola.schola.backbone.server.security.auth;

import org.jetbrains.annotations.NotNull;
import org.schola.schola.backbone.server.security.auth.exception.PasswordNotSecureException;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.password.CompromisedPasswordDecision;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;

@Component
public class WeakCompromisedPasswordChecker extends CompromisedPasswordCheckerWithRegex {

    public WeakCompromisedPasswordChecker() {
        super("^(?=[a-z]*)(?=[A-Z]*)[a-zA-Z]{,63}$");
    }

    @NotNull
    @Override
    public CompromisedPasswordDecision check(String password) {
        final boolean matches = this.getPattern().matcher(password).matches();
        if (matches) throw new PasswordNotSecureException();
        return new CompromisedPasswordDecision(true);
    }
}