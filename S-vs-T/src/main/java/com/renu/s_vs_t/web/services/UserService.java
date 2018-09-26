
package com.renu.s_vs_t.web.services;

import com.renu.s_vs_t.models.User;

public interface UserService {
  void saveUser(User user,String[] roles);
  User findByUsername(String username);
}
