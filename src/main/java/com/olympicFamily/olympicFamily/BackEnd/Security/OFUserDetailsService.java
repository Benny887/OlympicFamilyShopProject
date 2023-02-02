package com.olympicFamily.olympicFamily.BackEnd.Security;

import com.olympicFamily.olympicFamily.BackEnd.User.UserRepository;
import com.olympicFamily.olympicFamily.Common.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class OFUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.getUserByEmail(email);
        if(user != null){
            return new OFUserDetails(user);
        } else {
            throw new UsernameNotFoundException("Could not find user with email " + email);
        }
    }
}
