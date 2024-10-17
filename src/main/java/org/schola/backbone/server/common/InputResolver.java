package org.schola.backbone.server.common;

public interface InputResolver<R, T> {

    R fetch(T param);
    void purge(T param);

}