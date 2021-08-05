package com.ps.security;

import com.ps.exception.UnAuthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecutiryUserService secutiryUserService;
    @Autowired
    private JWTUtility jwtUtility;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         http.authorizeRequests()
         .antMatchers("/person").authenticated()
         .antMatchers("/address").authenticated()
         .antMatchers("/contact").permitAll()
         .and()
         .formLogin()
         .and()
         .httpBasic();
         **/
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/authenticate").permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.NEVER)
                .and()
                .httpBasic()
                .and()
                .addFilterBefore(new TokenAuthenticationFilter(jwtUtility, secutiryUserService), BasicAuthenticationFilter.class);

        ;


    }

    /**
     * @Override protected void configure(AuthenticationManagerBuilder auth) throws Exception {
     * InMemoryUserDetailsManager userDetailsService=new InMemoryUserDetailsManager();
     * UserDetails user= User.withUsername("admin")
     * .password("admin123")
     * .authorities("admin")
     * .build();
     * userDetailsService.createUser(user);
     * auth.userDetailsService(userDetailsService);
     * <p>
     * }
     **/

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(secutiryUserService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
        // return NoOpPasswordEncoder.getInstance();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
