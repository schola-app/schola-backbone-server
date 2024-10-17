package org.schola.schola.backbone.server.data.adapter;

import jakarta.persistence.AttributeConverter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class GrantedAuthoritiesAttributeAdapter
        implements AttributeConverter<Collection<? extends GrantedAuthority>, String> {

    @Override
    public String convertToDatabaseColumn(Collection<? extends GrantedAuthority> authorities) {
        final StringBuilder builder = new StringBuilder();
        for (GrantedAuthority authority : authorities) {
            final String name = authority.getAuthority();
            builder.append(name).append(",");
        }
        return builder.toString();
    }

    @Override
    public Collection<? extends GrantedAuthority> convertToEntityAttribute(String data) {
        String[] splited = data.split(",");
        return Arrays.stream(splited).map(SimpleGrantedAuthority::new).toList();
    }
}