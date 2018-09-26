package com.renu.s_vs_t.web.services;

public interface SecurityService {
  String findLoggedInUsername();
  void autologin(String username, String password);
}
