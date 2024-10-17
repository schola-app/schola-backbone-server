package org.schola.schola.backbone.server.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@Entity
@Table(name = "lunches-meals")
@RedisHash(value = "lunch-meal")
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class LunchMeal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false) private String name;

    @Column(nullable = false) private String description;

}