package com.rnc.javaskillsdemo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rnc.javaskillsdemo.models.Role;
import com.rnc.javaskillsdemo.models.User;
import com.rnc.javaskillsdemo.repositories.RoleRepo;
import com.rnc.javaskillsdemo.repositories.UserRepo;


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
    public void addAdminRole(User user) {
    	System.out.println(user);
    	System.out.println(bCrypt);
        List<Role> userroles = user.getRoles();
        List<Role> adminrole = roleRepo.findByName("ROLE_ADMIN");
    	List newList = Stream.concat(userroles.stream(), adminrole.stream()).collect(Collectors.toList());	
        user.setRoles(newList);
//        
//        userroles = userroles.addAll(adminrole);
//        user.setRoles(userroles);
        userRepo.save(user);
    }    
    
//    public void saveUserWithUserRole(User user) {
//    	System.out.println(user);
//    	System.out.println(bCrypt);
//        user.setPassword(bCrypt.encode(user.getPassword()));
//        user.setRoles(roleRepo.findByName("ROLE_USER"));
//        userRepo.save(user);
//    }  
    
    // 3
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
    
    public ArrayList<User> all() {
    	return (ArrayList<User>) userRepo.findAll();
    }
    
}
