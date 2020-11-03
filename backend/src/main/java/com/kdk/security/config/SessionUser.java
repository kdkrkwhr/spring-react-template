package com.kdk.security.config;

import java.io.Serializable;
import com.kdk.security.User;
import lombok.Getter;

@Getter
public class SessionUser implements Serializable {
  private String name;
  private String email;
  private String picture;

  public SessionUser(User user) {
    this.name = user.getName();
    this.email = user.getEmail();
    this.picture = user.getPicture();
  }
}
