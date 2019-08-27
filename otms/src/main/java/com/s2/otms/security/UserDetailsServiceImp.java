package com.s2.otms.security;

import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.s2.otms.model.User;

public class UserDetailsServiceImp implements UserDetailsService {
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    /*Here we are using dummy data, you need to load user data from
     database or other third party application*/
    User user = findUserbyUsername(username);

    UserBuilder builder = null;
    if (user != null) {
      builder = org.springframework.security.core.userdetails.User.withUsername(username);
      builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
      builder.roles(user.getRoles());
    } else {
      throw new UsernameNotFoundException("User not found.");
    }

    return builder.build();
  }

  private User findUserbyUsername(String username) {
    if("681222".equalsIgnoreCase(username)) {
      return new User(username, "681222", "USER");
    }
    if("876543".equalsIgnoreCase(username)) {
      return new User(username, "876543", "USER");
    }    
    if("admin".equalsIgnoreCase(username)) {
      return new User(username, "admin", "ADMIN");
    }
    return null;
  }
}
