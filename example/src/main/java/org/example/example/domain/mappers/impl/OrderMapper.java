package org.example.example.domain.mappers.impl;

import org.example.example.domain.dto.OrderDto;
import org.example.example.domain.entities.OrderEntity;
import org.example.example.domain.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Mapper implementation for converting between {@link OrderEntity} and {@link OrderDto}.
 * <p>
 * This class uses {@link ModelMapper} to map properties between the entity and DTO objects.
 * </p>
 */
@Component
public class OrderMapper implements Mapper<OrderEntity, OrderDto> {

  private final ModelMapper modelMapper;

  /**
   * Constructs a new OrderMapper with the specified {@link ModelMapper}.
   *
   * @param modelMapper the ModelMapper to be used for mapping
   */
  @Autowired
  public OrderMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  /**
   * Maps an {@link OrderEntity} to an {@link OrderDto}.
   *
   * @param orderEntity the source entity to be mapped
   * @return the mapped OrderDto
   */
  @Override
  public OrderDto mapEntityToDto(OrderEntity orderEntity) {
    return modelMapper.map(orderEntity, OrderDto.class);
  }

  /**
   * Maps an {@link OrderDto} to an {@link OrderEntity}.
   *
   * @param orderDto the source DTO to be mapped
   * @return the mapped OrderEntity
   */
  @Override
  public OrderEntity mapEntityFromDto(OrderDto orderDto) {
    return modelMapper.map(orderDto, OrderEntity.class);
  }

}
