package org.example.example.domain.ports;

import java.util.Optional;
import org.example.example.domain.dto.CustomerDto;
import org.example.example.domain.dto.OrderDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Interface defining the port for interacting with the application's core functionality related to customers and orders.
 * Implementations of this interface provide methods for adding new customers, retrieving customers and orders,
 * adding new orders, and retrieving order statuses.
 */
public interface AppPort {

  /**
   * Adds a new customer to the database.
   *
   * @param customerDto the CustomerDto object representing the customer to be added
   * @return an Optional containing the added CustomerDto if successful, empty otherwise
   */
  Optional<CustomerDto> addNewCustomerToDb(CustomerDto customerDto);

  /**
   * Retrieves a customer by their ID from the database
   *
   * //@param customerId the ID of the customer to retrieve
   * @return an Optional containing the CustomerDto if found, empty otherwise
   */
  Optional<CustomerDto> getCustomer(int customerId);

  /**
   * Adds a new order to the database
   *
   * @param orderDto the OrderDto object representing the order to be added
   * @return an Optional containing the added OrderDto if successful, empty otherwise
   */
  Optional<OrderDto> addNewOrderToDb(OrderDto orderDto);

  /**
   * Retrieves the status of an order by its ID from the database.
   *
   * @param orderId the ID of the order whose status to retrieve
   * @return an Optional containing the status of the order if found, empty otherwise
   */
  Optional<Integer> getOrderStatusFromDb(int orderId);

  /**
   * Retrieves all orders for a specific customer with pagination support.
   *
   * @param customerId the ID of the customer whose orders to retrieve
   * //@param pageable   the pagination information
   * //@return an Optional containing a page of OrderDto objects if found, empty otherwise
   */
  Optional<Page<OrderDto>> getAllOrderByCustomer(int customerId, Pageable pageable);
}
