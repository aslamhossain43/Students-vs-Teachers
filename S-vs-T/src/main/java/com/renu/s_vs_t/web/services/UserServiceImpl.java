package com.renu.s_vs_t.web.services;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.renu.s_vs_t.models.Role;
import com.renu.s_vs_t.models.User;
import com.renu.s_vs_t.web.repositories.UserRepository;




@Service
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER=LoggerFactory.getLogger(UserServiceImpl.class);
  @Autowired
  private UserRepository userRepository;
  
  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;
    
  @Override  
  public void saveUser(User user,String[] roles) {
	  LOGGER.info("From class UserServiceImpl,method : saveUser()");
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    Set<Role> rolesSet = new HashSet<Role>();
    for(String role:roles){
      rolesSet.add(new Role(role));
    }
    user.setRoles(rolesSet);
    userRepository.save(user);
  }
  @Override
  public User findByUsername(String username) {
	  LOGGER.info("From class UserServiceImpl,method : findByUsername()");
    return userRepository.findByUsername(username);
  }
}
