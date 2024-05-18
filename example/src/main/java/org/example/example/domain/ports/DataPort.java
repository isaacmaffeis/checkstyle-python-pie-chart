package org.example.example.domain.ports;

import org.example.example.domain.entities.CustomerEntity;
import org.example.example.domain.entities.OrderEntity;

/**
 * Interface for data access operations.
 * <p>
 * This interface provides methods for saving customer data, adding orders,
 * and retrieving order status. It acts as a port for data interactions.
 * </p>
 */
public interface DataPort {

  /**
   * Saves a customer entity.
   *
   * @param customerEntity the customer entity to be saved
   * @return the saved CustomerEntity
   */
  CustomerEntity saveCustomer(CustomerEntity customerEntity);

  /**
   * Adds an order entity.
   *
   * @param orderEntity the order entity to be added
   * @return the added OrderEntity
   */
  OrderEntity addOrder(OrderEntity orderEntity);

  /**
   * Retrieves the status of an order.
   *
   * @return the order status as an integer
   */
  int getOrderStatus(int orderId);

}
