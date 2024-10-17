package org.schola.backbone.server.security.auth;

import org.jetbrains.annotations.NotNull;
import org.schola.backbone.server.security.auth.exception.PasswordNotSecureException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.password.CompromisedPasswordDecision;

@Qualifier("weak")
public class WeakCompromisedPasswordChecker extends CompromisedPasswordCheckerWithRegex {

    public WeakCompromisedPasswordChecker() {
        super("^(?=[a-z]*)(?=[A-Z]*)[a-zA-Z]{12,63}$");
    }

    @NotNull
    @Override
    public CompromisedPasswordDecision check(String password) {
        final boolean matches = this.getPattern().matcher(password).matches();
        if (matches) throw new PasswordNotSecureException();
        return new CompromisedPasswordDecision(true);
    }
}