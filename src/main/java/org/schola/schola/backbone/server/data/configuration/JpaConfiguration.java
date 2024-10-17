package org.schola.schola.backbone.server.data.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "org.schola.schola.backbone.server.data.repository.jpa")
public class JpaConfiguration { }
