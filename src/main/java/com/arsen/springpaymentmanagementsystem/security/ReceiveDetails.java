package com.arsen.springpaymentmanagementsystem.security;

import com.arsen.springpaymentmanagementsystem.models.Receive;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class ReceiveDetails implements UserDetails {
    private Receive receive;

    public ReceiveDetails(Receive receive) {
        this.receive = receive;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(receive.getRole()));
    }

    @Override
    public String getPassword() {
        return this.receive.getCode();
    }

    @Override
    public String getUsername() {
        return this.receive.getEmail();
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

    public Receive getReceive() {
        return this.receive;
    }
}
