package com.example.demo.security;

import com.example.demo.services.UserService;
import com.proto.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
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
        User user = service.getUser(username);
        Collection<SimpleGrantedAuthority> authorities = new HashSet<>();
        SimpleGrantedAuthority roleUser=new SimpleGrantedAuthority("ROLE_USER");
        SimpleGrantedAuthority roleFarmer=new SimpleGrantedAuthority("ROLE_FARMER");
        if(user.getIsFarmer()){
            authorities.add(roleFarmer);
        }else{
            authorities.add(roleUser);
        }

        UserDetailsImpl userDetails = new UserDetailsImpl( authorities, passwordEncoder.encode(user.getPassword()), user.getEmail());
        //userDetails.addAuthority(new GrantedAuthority("ROLE_USER"));
        return userDetails;
    }
}
