package org.schola.schola.backbone.server.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@Entity
@Table(name = "calendar-events")
@RedisHash(value = "calendar-events")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CalendarEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String date;

    @OneToOne
    private Calendar calendar;

}