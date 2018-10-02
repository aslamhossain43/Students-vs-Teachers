package com.renu.s_vs_t.web.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.renu.s_vs_t.models.User;


public interface UserRepository extends JpaRepository<User, Long>{
  public User findByUsername(String username);
  @Modifying
	@Transactional
 @Query("UPDATE User SET password=:pwd WHERE username=:username")
	public void updatePassword(@Param("pwd") String pwd, @Param("username")String username);
	
}
