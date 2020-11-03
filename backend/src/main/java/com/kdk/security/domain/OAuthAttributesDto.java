package com.kdk.security.domain;

import java.util.Map;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OAuthAttributesDto {
  private Map<String, Object> attributes;
  private String nameAttributeKey;
  private String name;
  private String email;
  private String picture;

  @Builder
  public OAuthAttributesDto(Map<String, Object> attributes, String nameAttributeKey, String name,
      String email, String picture) {
    this.attributes = attributes;
    this.nameAttributeKey = nameAttributeKey;
    this.name = name;
    this.email = email;
    this.picture = picture;
  }

  public static OAuthAttributesDto of(String registrationId, String userNameAttributeName,
      Map<String, Object> attributes) {

    return ofGoogle(userNameAttributeName, attributes);
  }

  public static OAuthAttributesDto ofGoogle(String userNameAttributeName,
      Map<String, Object> attributes) {

    return OAuthAttributesDto.builder().name((String) attributes.get("name"))
        .email((String) attributes.get("email")).picture((String) attributes.get("picture"))
        .attributes(attributes).nameAttributeKey(userNameAttributeName).build();
  }

  public UserDto toEntity() {
    return UserDto.builder().name(name).email(email).picture(picture).role(Role.GUEST).build();
  }
}
