package org.schola.backbone.server.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.redis.core.RedisHash;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "libraries")
@RedisHash(value = "library")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany
    private List<LibraryBook> books;

    @CreatedDate private Date created;

    @UpdateTimestamp private Date updated;

}