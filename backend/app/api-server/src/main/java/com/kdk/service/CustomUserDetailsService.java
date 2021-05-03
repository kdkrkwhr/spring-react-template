package com.kdk.service;

import com.kdk.common.SecurityUser;
import com.kdk.domain.user.User;
import com.kdk.domain.user.UserRepository;
import com.kdk.exception.DeleteUserException;
import com.kdk.exception.NotExistUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import static java.util.Objects.nonNull;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {
    User user = userRepository.findByIdentifier(identifier)
        .orElseThrow(() -> new NotExistUserException("로그인에 실패하였습니다."));

    if (user.getDisabledYn().equals('Y')) {
      throw new DeleteUserException("이미 탈퇴된 유저입니다. 아이디를 다시 만들어주세요.");
    }

    if (nonNull(RequestContextHolder.getRequestAttributes())) {
      HttpServletRequest request =
          ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
      request.getSession().setAttribute("user", user.toResponseDto(user));
    }

    return new SecurityUser(user);
  }
}
