package com.ps.controller;

import com.ps.DTO.JWTRequestDTO;
import com.ps.DTO.JWTResponseDTO;
import com.ps.exception.ErrorCode;
import com.ps.exception.UnAuthorizedException;
import com.ps.security.JWTUtility;
import com.ps.security.SecurityUser;
import com.ps.security.SecutiryUserService;
import com.ps.utility.Constants;
import com.ps.utility.DeviceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class JWTAuthenticateController {
    @Autowired
    private JWTUtility jwtUtility;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private SecutiryUserService secutiryUserService;
    @Autowired
    private DeviceProvider deviceProvider;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(
            @RequestBody JWTRequestDTO authenticationRequest,
            HttpServletResponse response,
            HttpServletRequest httpServletRequest
    ) throws AuthenticationException, IOException {

        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUserName(),
                        authenticationRequest.getUserPassword()
                )
        );

        // Inject into security context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // token creation
        UserDetails userDetails = secutiryUserService.loadUserByUsername(authenticationRequest.getUserName());
        String JWTToken = jwtUtility.generateToken(userDetails.getUsername(), deviceProvider.getCurrentDevice(httpServletRequest));

        Long expiresIn = jwtUtility.getExpiredIn(deviceProvider.getCurrentDevice(httpServletRequest));
        // Return the token
        return ResponseEntity.ok(new JWTResponseDTO(JWTToken, expiresIn));
    }
}
