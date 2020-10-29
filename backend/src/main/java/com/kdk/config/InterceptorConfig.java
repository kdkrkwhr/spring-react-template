package com.kdk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.kdk.util.HandlerAuthInterceptorUtil;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

  @Bean
  public HandlerAuthInterceptorUtil handshakeInterceptor() {
      return new HandlerAuthInterceptorUtil();
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(handshakeInterceptor())
        .excludePathPatterns("/");
  }
}
