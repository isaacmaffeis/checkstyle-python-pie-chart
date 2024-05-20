package org.example.example.domain;

import java.util.Optional;
import org.example.example.domain.dto.CustomerDto;
import org.example.example.domain.dto.OrderDto;
import org.example.example.domain.entities.CustomerEntity;
import org.example.example.domain.entities.OrderEntity;
import org.example.example.domain.mappers.impl.CustomerMapper;
import org.example.example.domain.mappers.impl.OrderMapper;
import org.example.example.domain.ports.AppPort;
import org.example.example.domain.ports.DataPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Service class implementing the {@code AppPort} interface for managing customer and order-related functionalities.
 */
@Service
public class OrdersManager implements AppPort {

  private final CustomerMapper customerMapper;
  private final OrderMapper ordersMapper;
  private final DataPort dataPort;

  /**
   * Constructs an instance of {@code OrdersManager} with the specified mappers and data port.
   *
   * @param customerMapper the mapper for customer-related operations
   * @param orderMapper    the mapper for order-related operations
   * @param dataPort       the port for interacting with the data layer
   */
  public OrdersManager (CustomerMapper customerMapper, OrderMapper orderMapper, DataPort dataPort){
    this.customerMapper = customerMapper;
    this.ordersMapper = orderMapper;
    this.dataPort = dataPort;
  }

  @Override
  public Optional<CustomerDto> addNewCustomerToDb(CustomerDto customerDto) {
    CustomerEntity customerEntity = customerMapper.mapEntityFromDto(customerDto);
    Optional<CustomerEntity> savedCustomerEntity = dataPort.saveCustomer(customerEntity);
    CustomerDto savedCustomerDto = null;
    if (savedCustomerEntity.isPresent()) {
      savedCustomerDto = customerMapper.mapEntityToDto(savedCustomerEntity.get());
    }
    return Optional.ofNullable(savedCustomerDto);
  }

  @Override
  public Optional<CustomerDto> getCustomer(int customerId) {
    if (!dataPort.customerIsExists(customerId)) {
        return Optional.empty();
    }
    Optional<CustomerEntity> customerEntity = dataPort.getCustomer(customerId);
    return customerEntity.map(customerMapper::mapEntityToDto);
  }

  @Override
  public Optional<OrderDto> addNewOrderToDb(OrderDto orderDto) {
    OrderEntity orderEntity = ordersMapper.mapEntityFromDto(orderDto);
    orderEntity.setStatus(1);
    Optional<OrderEntity> savedOrderEntity = dataPort.addOrder(orderEntity);
    return savedOrderEntity.map(ordersMapper::mapEntityToDto);
  }

  @Override
  public Optional<Integer> getOrderStatusFromDb(int orderId) {
    if (!dataPort.orderIsExists(orderId)) //{
      return Optional.empty();
    //}
    return Optional.of(dataPort.getOrderStatus(orderId));
  }

  @Override
  public Optional<Page<OrderDto>> getAllOrderByCustomer(int customerId, Pageable pageable) {
    if (!dataPort.customerIsExists(customerId))
      return Optional.empty();

    Page<OrderEntity> pageEntity = dataPort.getAllOrdersByCustomerId(customerId, pageable);
    return Optional.of(pageEntity.map(ordersMapper::mapEntityToDto));
  }

}
