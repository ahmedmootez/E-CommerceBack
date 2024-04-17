package com.youtube.jwt.service;


import com.youtube.jwt.dao.RoleDao;
import com.youtube.jwt.dao.UserDao;
import com.youtube.jwt.entity.ConfirmationToken;
import com.youtube.jwt.entity.Role;
import com.youtube.jwt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private  ConfirmationTokenService confirmationTokenService;
   
    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleDao.save(userRole);

       /* User adminUser = new User();
        adminUser.setEmail("admin123");
        adminUser.setUserPassword(getEncodedPassword("admin@pass"));
        adminUser.setFirstName("admin");
        adminUser.setLastName("admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);*/


    }
    
    
    public String signUpUser(User user) {
    	Optional<User> userExists = userDao.findByEmail(user.getEmail());
    	Optional<User> usernameTaken=userDao.findById(user.getUserName());
       
        
        

        if (userExists.isPresent() && userExists.get().getEnabled() ) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.
        		return "email already taken";
            //throw new IllegalStateException("email already taken");
        }
        
        if(usernameTaken.isPresent() && usernameTaken.get().getEnabled()) {
        	return "username already taken";
        }
        
        Role role = roleDao.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        String encodedPassword = getEncodedPassword(user.getUserPassword());

        user.setUserPassword(encodedPassword);

        userDao.save(user);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );

        confirmationTokenService.saveConfirmationToken(
                confirmationToken);

//        TODO: SEND EMAIL

        return token;
    }

    public String registerNewUser(User user) {
        Role role = roleDao.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));

        userDao.save(user);
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );

        confirmationTokenService.saveConfirmationToken(
                confirmationToken);
        
        
return token;
        
    }
    
    
    
    
    
    public int enableAppUser(String email) {
        return userDao.enableAppUser(email);
    }
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
