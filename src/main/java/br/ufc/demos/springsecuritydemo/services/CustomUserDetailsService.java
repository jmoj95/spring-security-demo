package br.ufc.demos.springsecuritydemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.ufc.demos.springsecuritydemo.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
            .findByUsername(username)
            .map(u -> new User(
                u.getUsername(),
                u.getPassword(),
                true,
                true,
                true,
                true,
                AuthorityUtils.createAuthorityList(
                    "ROLE_" + u.getRole().getName().toUpperCase())
            )).get();
    }

}