package org.example.webcontacts.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MVCConfig implements WebMvcConfigurer {
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
        .addResourceHandler("favicons/*")
        .addResourceLocations("classpath:static/favicons/");
    registry
        .addResourceHandler("css/*")
        .addResourceLocations("classpath:static/css/");
    registry
        .addResourceHandler("fonts/*")
        .addResourceLocations("classpath:static/fonts/");
  }

}