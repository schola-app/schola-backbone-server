package org.schola.backbone.server.data.model;

import jakarta.persistence.*;
import org.springframework.data.redis.core.RedisHash;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "launches")
@RedisHash(value = "launch")
public class Lunch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false) private Date date;

    @OneToMany @Column private List<LunchMeal> meals;

}