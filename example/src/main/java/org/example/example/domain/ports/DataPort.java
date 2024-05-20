package org.example.example.domain.ports;

import java.util.Optional;
import org.example.example.domain.entities.CustomerEntity;
import org.example.example.domain.entities.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Interface for data access operations.
 * <p>
 * This interface provides methods for saving customer data, adding orders,
 * and retrieving order status. It acts as a port for data interactions.
 * </p>
 */
public interface DataPort {

  Optional<CustomerEntity> saveCustomer(CustomerEntity customerEntity);

  boolean customerIsExists(int customerId);

  Optional<CustomerEntity> getCustomer(int customerId);

  Optional<OrderEntity> addOrder(OrderEntity orderEntity);

  boolean orderIsExists(int orderId);

  int getOrderStatus(int orderId);

  Page<OrderEntity> getAllOrdersByCustomerId(int customerId, Pageable pageable);
}
