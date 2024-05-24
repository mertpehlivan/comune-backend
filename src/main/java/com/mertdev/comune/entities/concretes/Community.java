package com.mertdev.comune.entities.concretes;

import com.mertdev.comune.entities.abstracts.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "communityies")
public class Community extends AccountAbstract implements UserDetails {
    private String name;
    @Enumerated(EnumType.STRING)
    private AccountRole accountRole;
    private String password;
    @Column(name = "email", unique = true)
    private String email;
    private String aboutUs;
    @Enumerated(EnumType.STRING)
    private Privacy privacy;

    @Enumerated(EnumType.STRING)
    private CommunityShareRole communityShareRole;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "theme_id", referencedColumnName = "id")
    private Theme theme;

    @OneToMany(mappedBy = "community",cascade = CascadeType.ALL)
    private Set<Publication> publications;



    @OneToMany(mappedBy = "community", cascade = CascadeType.ALL)
    private Set<UserCommunityRole> userRoles;

    private String location;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(accountRole.name()));
    }

    @Override
    public String getUsername() {
        return this.getEmail();
    }


    @Override
    public String getPassword() {
        return this.password;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
