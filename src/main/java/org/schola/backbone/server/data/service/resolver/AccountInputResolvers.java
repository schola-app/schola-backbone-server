package org.schola.backbone.server.data.service.resolver;

public interface AccountInputResolvers {

    Class<? extends AccountInputResolver<Long>> ID = AccountInputResolverWithIdentifier.class;
    Class<? extends AccountInputResolver<String>> USERNAME = AccountInputResolverWithUsername.class;

}