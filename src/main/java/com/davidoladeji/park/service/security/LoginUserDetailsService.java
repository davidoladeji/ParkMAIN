package com.davidoladeji.park.service.security;

import com.davidoladeji.park.model.Account;
import com.davidoladeji.park.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Daveola on 03-Dec-14.
 */

@Service
@Transactional(readOnly = true)
public class LoginUserDetailsService implements UserDetailsService {

    /**
     * A custom {UserDetailsService} where user information
     * is retrieved from a JPA repository
     */

    @Autowired
    AccountService accountService;

    /**
     * Wraps {@link String} roles to {@link SimpleGrantedAuthority} objects
     *
     * @param roles {@link String} of roles
     * @return list of granted authorities
     */
    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

    /**
     * Returns a populated {@link UserDetails} object.
     * The username is first retrieved from the database and then mapped to
     * a { UserDetails} object.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Account accountX = accountService.findByEmail(username);

            boolean enabled = accountX.isEnabled();
            boolean accountNonExpired = true;
            boolean credentialsNonExpired = true;
            boolean accountNonLocked = true;

            return new User(
                    accountX.getUsername(),
                    accountX.getPassword(),
                    enabled,
                    accountNonExpired,
                    credentialsNonExpired,
                    accountNonLocked,
                    getAuthorities(accountX.getUserRole().getId()));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves a collection of {@link GrantedAuthority} based on a numerical role
     *
     * @param role the numerical role
     * @return a collection of {@link GrantedAuthority
     */
    public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
        return authList;
    }

    /**
     * Converts a numerical role to an equivalent list of roles
     *
     * @param role the numerical role
     * @return list of roles as as a list of {@link String}
     */
    public List<String> getRoles(Integer role) {
        List<String> roles = new ArrayList<String>();

        if (role.intValue() == 1) {
            roles.add("ROLE_ADMIN");
        } else if (role.intValue() == 2) {
            roles.add("ROLE_STAFF");
        } else if (role.intValue() == 3) {
            roles.add("ROLE_USER");
        }

        return roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoginUserDetailsService)) return false;

        LoginUserDetailsService that = (LoginUserDetailsService) o;

        if (accountService != null ? !accountService.equals(that.accountService) : that.accountService != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return accountService != null ? accountService.hashCode() : 0;
    }
}
