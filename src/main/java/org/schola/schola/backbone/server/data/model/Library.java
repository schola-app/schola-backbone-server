package org.schola.schola.backbone.server.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.redis.core.RedisHash;

import java.util.Collection;
import java.util.Date;

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

    @ManyToOne
    private Collection<LibraryBook> books;

    @CreatedDate private Date created;

    @UpdateTimestamp private Date updated;

}