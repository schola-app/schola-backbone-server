package org.schola.backbone.server.security.auth.exception;

public class PasswordNotSecureException extends RuntimeException {

    public PasswordNotSecureException() {
        super("Password is not secure");
    }

    public PasswordNotSecureException(String message) {
        super(message);
    }
}
