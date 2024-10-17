package org.schola.schola.backbone.server.security.auth;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.security.password.checker")
public class CompromisedPasswordCheckerConfiguration {

    private String secure;

}