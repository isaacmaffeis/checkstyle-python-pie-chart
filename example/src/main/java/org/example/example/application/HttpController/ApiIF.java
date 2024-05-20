package org.example.example.application.HttpController;

import java.util.List;
import org.example.example.domain.dto.CustomerDto;
import org.example.example.domain.dto.OrderDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

/**
 * Interface defining the API endpoints for managing customers and orders.
 */
@RequestMapping(path = "/orders")
public interface ApiIF {

  /**
   * Adds a new customer with the given name.
   *
   * @param name the name of the customer to be added
   * @return a ResponseEntity containing the added CustomerDto
   */
  @PostMapping(path = "/customer")
  ResponseEntity<CustomerDto> addNewCustomer(@RequestParam("customer_name") String name);

  /**
   * Adds a new order for a specific customer with the given dish ID.
   *
   * @param customerId the ID of the customer who is placing the order
   * @param dishId     the ID of the dish being ordered
   * @return a ResponseEntity containing the added OrderDto
   */
  @PostMapping(path = "/order/{customer_id}")
  ResponseEntity<OrderDto> addNewOrder(@PathVariable("customer_id") int customerId
      ,@RequestParam("dish_id") String dishId);

  /**
   * Retrieves the status of an order by its ID.
   *
   *
   * @param orderId the ID of the order whose status is being retrieved
   * @return a ResponseEntity containing the status of the order
   */
  @GetMapping(path = "/order")
  ResponseEntity<Integer> getOrderStatus(@RequestParam int orderId);

  /**
   * Retrieves all orders for a specific customer, with pagination support.
   *
   * @param customerId the ID of the customer whose orders are being retrieved
   * //@param pageable   the pagination information
   * @return a ResponseEntity containing a page of OrderDto objects
   */
  @GetMapping(path = "/customer/{customer_id}")
  ResponseEntity<Page<OrderDto>> getAllOrdersByCustomer(@PathVariable("customer_id") int customerId,
      Pageable pageable);

}