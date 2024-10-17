package org.schola.schola.backbone.server.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.data.redis.core.RedisHash;

@Entity
@Table(name = "launches-menus")
@RedisHash(value = "lunch-menu")
public class LunchMenu {
}
