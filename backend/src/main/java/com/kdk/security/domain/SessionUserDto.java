package com.kdk.security.domain;

import java.io.Serializable;
import lombok.Getter;

@Getter
public class SessionUserDto implements Serializable {
  private String name;
  private String email;
  private String picture;

  public SessionUserDto(UserDto user) {
    this.name = user.getName();
    this.email = user.getEmail();
    this.picture = user.getPicture();
  }
}
