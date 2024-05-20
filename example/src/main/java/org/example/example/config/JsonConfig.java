package org.example.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * Configuration class for customizing Jackson ObjectMapper.
 */
@Configuration
public class JsonConfig {

  /**
   * Configures and provides a customized ObjectMapper bean.
   *
   * @return an instance of ObjectMapper configured with custom settings
   */
  @Bean
  public ObjectMapper objectMapper(){
    final ObjectMapper objectMapper = new ObjectMapper();

    // Register JavaTimeModule to support Java 8 Date/Time API
    objectMapper.registerModule(new JavaTimeModule());

    // Configure date format to be used for serialization and deserialization
    objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));

    return objectMapper;
  }

}