package org.schola.backbone.server.data.model;

import jakarta.persistence.*;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

@Entity
@Table(name = "launches-menus")
@RedisHash(value = "lunch-menu")
public class LunchMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany private List<LunchMeal> meals;

}