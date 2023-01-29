package com.olympicFamily.olympicFamily.BackEnd.User;

import com.olympicFamily.olympicFamily.Common.Entity.Role;
import com.olympicFamily.olympicFamily.Common.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> listAll(){
        return (List<User>) userRepo.findAll();
    }

    public List<Role> listRoles(){
        return (List<Role>) roleRepo.findAll();
    }

    public void save(User user) {
        encodePassword(user);
        userRepo.save(user);
    }

    private void encodePassword(User user){
        String encoderPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encoderPassword);
    }

    public boolean isEmailUnique(String emil){
        User userByEmail = userRepo.getUserByEmail(emil);
        return userByEmail == null;
    }
}
