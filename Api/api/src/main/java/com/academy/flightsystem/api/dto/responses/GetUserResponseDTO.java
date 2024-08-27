package com.academy.flightsystem.api.dto.responses;

import com.academy.flightsystem.api.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserResponseDTO {

    private Long id;

    private String username;

    private String roles;

    private Date createdAt;

    private Date updatedAt;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(roles.split(",+")).map(SimpleGrantedAuthority::new).toList();
    }

    public GetUserResponseDTO(User user)
    {
        this.id = user.getId();
        this.username = user.getUsername();
        this.roles = user.getRoles();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
    }
}
