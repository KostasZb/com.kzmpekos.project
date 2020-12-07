package com.example.demo.security;

import com.example.demo.services.UserService;
import com.proto.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService service;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Getting the user from the userservice
        User user = service.getUser(username);
        Collection<SimpleGrantedAuthority> authorities = new HashSet<>();
        //Creating the granted authorities
        SimpleGrantedAuthority roleUser = new SimpleGrantedAuthority("ROLE_" + ApplicationUserRole.USER.name());
        SimpleGrantedAuthority roleFarmer = new SimpleGrantedAuthority("ROLE_" + ApplicationUserRole.FARMER.name());
        //Adding the proper authority tp the user
        if (user.getIsFarmer()) {
            authorities.add(roleFarmer);
        } else {
            authorities.add(roleUser);
        }
        UserDetailsImpl userDetails = new UserDetailsImpl(authorities, passwordEncoder.encode(user.getPassword()), user.getEmail());
        userDetails.setUserId(user.getUserId());
        return userDetails;
    }
}
