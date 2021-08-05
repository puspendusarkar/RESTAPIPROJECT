package com.ps.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private JWTUtility jwtUtility;
    private SecutiryUserService secutiryUserService;

    public TokenAuthenticationFilter(JWTUtility jwtUtility, SecutiryUserService secutiryUserService) {
        this.jwtUtility = jwtUtility;
        this.secutiryUserService = secutiryUserService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {


        String username;
        String authToken = jwtUtility.getToken(httpServletRequest);

        if (authToken != null) {
            // get username from token
            username = jwtUtility.getUsernameFromToken(authToken);
            if (username != null) {
                // get user
                UserDetails userDetails = secutiryUserService.loadUserByUsername(username);
                if (jwtUtility.validateToken(authToken, userDetails)) {
                    // create authentication
                    TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails);
                    authentication.setToken(authToken);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
