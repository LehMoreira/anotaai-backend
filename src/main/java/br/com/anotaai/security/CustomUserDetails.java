package br.com.anotaai.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



import br.com.anotaai.entity.Usuario;

public class CustomUserDetails implements UserDetails {
	private final Usuario user;

    public CustomUserDetails(Usuario user) {
        this.user = user;
    }

    public Long getId() {
        return user.getId();
    }


    public String getEmail() {
        return user.getEmail();
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
    public Usuario getUser() {
        return user;
    }
    public String getPassword() {
        return user.getPassword();
    }

    public String getUsername() {
        return user.getLogin();
    }

    public boolean isAccountNonExpired() { return true; }

    public boolean isAccountNonLocked() { return true; }

    public boolean isCredentialsNonExpired() { return true; }

    public boolean isEnabled() { return true; }

}
