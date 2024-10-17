package org.schola.backbone.server.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.redis.core.RedisHash;

import java.util.Date;

@Entity
@Table(name = "library_books")
@RedisHash(value = "library_book")
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class LibraryBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column private String name;

    @Column private String editor;

    @Column private String author;

    @Column private boolean available;

    @OneToOne private Account reserved;

    @CreatedDate private Date created;

    @UpdateTimestamp private Date updated;

    @ManyToOne
    private Library library;

}
