package com.kdk.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HandlerAuthInterceptorUtil extends HandlerInterceptorAdapter {

  private static final Logger logger = LoggerFactory.getLogger(HandlerAuthInterceptorUtil.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    logger.debug("********** preHandle :: START Call API : {} **********",
        request.getRequestURL().toString());
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    logger.debug("********** postHandle :: END Call API : {} **********",
        request.getRequestURL().toString());
  }
}
