package com.renu.s_vs_t.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renu.s_vs_t.models.User;


public interface UserRepository extends JpaRepository<User, Long>{
  public User findByUsername(String username);
  
}
