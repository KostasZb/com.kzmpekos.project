package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.servlet.support.csrf.CsrfRequestDataValueProcessor;
import org.springframework.web.servlet.support.RequestDataValueProcessor;

//REFERENCE: https://www.youtube.com/watch?v=her_7pa0vrg&t=11987s&ab_channel=Amigoscode

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Qualifier("userDetailsServiceImpl")
    @Autowired
    UserDetailsService userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .antMatchers("/", "index", "login", "signup", "/js/*").permitAll()
                .antMatchers("/market").hasAnyRole(ApplicationUserRole.USER.name(),ApplicationUserRole.FARMER.name())
                .antMatchers("/farmerhome","/farmerhome/addProduct").hasRole(ApplicationUserRole.FARMER.name())
                .and()
                .formLogin().loginPage("/login").usernameParameter("email").and()
                .logout().logoutUrl("/logout").clearAuthentication(true).invalidateHttpSession(true).deleteCookies("JSESSIONID");
    }


    //Setting the password encoder
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

}
