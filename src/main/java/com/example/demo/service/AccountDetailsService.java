package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AccountDetails;
import com.example.demo.repository.UserRepository;

@Service
public class AccountDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUserName(username)
            .map(
                user-> new AccountDetails(
                    user.getId(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getTotalExperience(),
                    user.getLevel()
                )
            )
            .orElseThrow(() -> new UsernameNotFoundException("Username is not found."));
    }
    
}
