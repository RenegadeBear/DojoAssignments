package com.rnc.firstsafeapp.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rnc.firstsafeapp.models.User;
import com.rnc.firstsafeapp.repositories.RoleRepo;
import com.rnc.firstsafeapp.repositories.UserRepo;


@Service
public class UserService {
    private UserRepo userRepo;
    private RoleRepo roleRepo;
    private BCryptPasswordEncoder bCrypt;
    
    public UserService(UserRepo userRepo, RoleRepo roleRepo, BCryptPasswordEncoder bCrypt) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.bCrypt = bCrypt;
    }
        
    // 1
    public void saveWithUserRole(User user) {
        user.setPassword(bCrypt.encode(user.getPassword()));
        user.setRoles(roleRepo.findByName("ROLE_USER"));
        userRepo.save(user);
    }
     
     // 2 
    public void saveUserWithAdminRole(User user) {
    	System.out.println(user);
    	System.out.println(bCrypt);
        user.setPassword(bCrypt.encode(user.getPassword()));
        user.setRoles(roleRepo.findByName("ROLE_ADMIN"));
        userRepo.save(user);
    }    
    
    // 3
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
    
}
