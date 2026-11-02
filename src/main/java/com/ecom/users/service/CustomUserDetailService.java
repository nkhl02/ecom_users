package com.ecom.users.service;

import com.ecom.users.entity.User;
import com.ecom.users.enums.Status;
import com.ecom.users.exception.custom.EmailAlreadyExistsException;
import com.ecom.users.exception.custom.EmailNotFoundException;
import com.ecom.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {


    private final UserRepository userRepository;



    CustomUserDetailService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<User> user = this.userRepository.findByEmailAndStatus(email, Status.ACTIVE).stream().findFirst();

        if(user.isPresent()){
              return org.springframework.security.core.userdetails.User
                      .withUsername(user.get().getEmail())
                      .password(user.get().getPasswordHash())
                      .roles(user.get().getRole().name())
                      .build();
        }else{
            throw new EmailNotFoundException("Entered email does not exist");
        }


    }
}
