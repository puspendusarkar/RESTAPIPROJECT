package com.ps.security;

import com.ps.entities.UserEntity;
import com.ps.exception.ErrorCode;
import com.ps.exception.ResourceNotFoundException;
import com.ps.exception.UnAuthorizedException;
import com.ps.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SecutiryUserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UnAuthorizedException {
      //  System.out.println("user name " +userName);
        List<UserEntity> userEntities= userRepository.findByUsername(userName);
        if(userEntities.size()==0) {
            throw new UnAuthorizedException("user details not found for the user " + userName, ErrorCode.HTTP_UNAUTHORIZED_EXCEPTION);
        }
        UserEntity user=userEntities.get(0);
        //String pwd=user.getPassword();
        user.setPassword(user.getPassword().trim());
        //System.out.println("User...."+user.getUsername());
        //System.out.println("Password: "+user.getPassword());

        return new SecurityUser(user);
    }
}
