package org.schola.backbone.server.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.redis.core.RedisHash;

import java.sql.Date;

@Entity
@Table(name = "task")
@RedisHash(value = "task")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 64) private String name;

    @Column(length = 4096) private String description;

    @Column(length = 64) private long end;

    @Column(nullable = false) private boolean finished;

    @OneToOne private Task child;

    @CreatedDate private Date created;

    @UpdateTimestamp private Date updated;

}