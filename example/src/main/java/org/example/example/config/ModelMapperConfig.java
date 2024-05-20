package org.example.example.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for setting up the ModelMapper bean.
 * <p>
 * ModelMapper is used for object mapping, particularly mapping between
 * different layers of an application such as DTOs and entities.
 * </p>
 */
@Configuration
public class ModelMapperConfig {

  /**
   * Creates and configures a ModelMapper bean.
   * <p>
   * The ModelMapper is configured with a loose matching strategy, which is
   * useful for nested object mapping and allows for more flexible property
   * matching.
   * </p>
   *
   * @return a configured ModelMapper instance
   */
  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();
    // Nested Object config
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    return modelMapper;
  }

}
