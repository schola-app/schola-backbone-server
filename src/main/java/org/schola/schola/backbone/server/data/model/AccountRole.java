package org.schola.schola.backbone.server.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 */
@AllArgsConstructor
@Getter
public enum AccountRole {

    NONE,
    STUDENT,
    TEACHER,
    ADMIN,
    DEVELOPER

}