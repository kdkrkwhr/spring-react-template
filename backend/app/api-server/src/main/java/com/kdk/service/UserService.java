package com.kdk.service;

import com.kdk.domain.enums.Role;
import com.kdk.domain.user.UserRepository;
import com.kdk.dto.*;
import com.kdk.exception.DuplicatedException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  // 일반유저 회원가입
  public void userRegistration(UserRequestDto userRequestDto) {
    userRequestDto.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
    userRequestDto.setAuthorities(Role.USER.getKey());

    userRepository.save(userRequestDto.toEntity());
  }

  public boolean duplicateCheck(String identifier) {
    if (userRepository.existsByIdentifier(identifier)) {
      throw new DuplicatedException("이미 등록된 아이디 입니다!");
    }

    return true;
  }

  private boolean isPasswordEquals(String password1, String password2) {
    return passwordEncoder.matches(password1, password2);
  }

}
