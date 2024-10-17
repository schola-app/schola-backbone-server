package org.schola.schola.backbone.server.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.schola.schola.backbone.server.data.adapter.GrantedAuthoritiesAttributeAdapter;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 *
 */
@Entity
@Table(name = "accounts")
@RedisHash(value = "account")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Account implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 64, nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean enabled;

    @Column(nullable = false)
    private long created;

    @Column(nullable = false)
    private long updated;

    @Column
    @Convert(converter = GrantedAuthoritiesAttributeAdapter.class)
    private Collection<? extends GrantedAuthority> authorities;

    @Enumerated(EnumType.ORDINAL)
    @Column
    private AccountRole role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
}