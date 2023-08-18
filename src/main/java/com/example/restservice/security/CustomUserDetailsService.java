package com.example.restservice.security;

import com.example.restservice.models.UserEntity;
import com.example.restservice.models.Role;
import com.example.restservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Go into our userRepository and grab our user
    // We are going to find them by username, or else throw a username not found error
    // There is a nice exception provided, so we don't have to go into the global exception handler
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return new User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    // We are converting our Roles into a list and then using them as GrantedAuthorities
    // Essentially mapping the Roles to Authorities
    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> role) {
        return role.stream().map(roles -> new SimpleGrantedAuthority(roles.getName())).collect(Collectors.toList());
    }

}
