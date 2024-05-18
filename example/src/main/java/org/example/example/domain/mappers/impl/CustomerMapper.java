package org.example.example.domain.mappers.impl;

import org.example.example.domain.dto.CustomerDto;
import org.example.example.domain.entities.CustomerEntity;
import org.example.example.domain.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Mapper implementation for converting between {@link CustomerEntity} and {@link CustomerDto}.
 * <p>
 * This class uses {@link ModelMapper} to map properties between the entity and DTO objects.
 * </p>
 */
@Component
public class CustomerMapper implements Mapper<CustomerEntity, CustomerDto> {

  private final ModelMapper modelMapper;

  /**
   * Constructs a new CustomerMapper with the specified {@link ModelMapper}.
   *
   * @param modelMapper the ModelMapper to be used for mapping
   */
  @Autowired
  public CustomerMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  /**
   * Maps a {@link CustomerEntity} to a {@link CustomerDto}.
   *
   * @param customerEntity the source entity to be mapped
   * @return the mapped CustomerDto
   */
  @Override
  public CustomerDto mapEntityToDto(CustomerEntity customerEntity) {
    return modelMapper.map(customerEntity, CustomerDto.class);
  }

  /**
   * Maps a {@link CustomerDto} to a {@link CustomerEntity}.
   *
   * @param customerDto the source DTO to be mapped
   * @return the mapped CustomerEntity
   */
  @Override
  public CustomerEntity mapEntityFromDto(CustomerDto customerDto) {
    return modelMapper.map(customerDto, CustomerEntity.class);
  }

}
