package org.example.example.infrastructure.repository;

import java.util.Optional;
import org.example.example.domain.entities.CustomerEntity;
import org.example.example.domain.entities.OrderEntity;
import org.example.example.domain.ports.DataPort;
import org.example.example.infrastructure.repository.repositories.CustomerRepository;
import org.example.example.infrastructure.repository.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


/**
 * Adapter class implementing the {@link DataPort} interface for data access using JPA
 * repositories.
 * <p>
 * This class interacts with the database using Spring Data JPA repositories to perform operations
 * such as saving customers, adding orders, and retrieving order status.
 * </p>
 */
@Repository
public class JpaAdapter implements DataPort {

  private final CustomerRepository customerRepository;
  private final OrderRepository orderRepository;

  /**
   * Constructs a new JpaAdapter with the specified CustomerRepository and OrderRepository.
   *
   * @param customerRepository the repository for accessing and managing customer data
   * @param orderRepository    the repository for accessing and managing order data
   */
  @Autowired
  public JpaAdapter(CustomerRepository customerRepository, OrderRepository orderRepository) {
    this.customerRepository = customerRepository;
    this.orderRepository = orderRepository;
  }

  /**
   * Saves a customer entity.
   *
   * @param customerEntity the customer entity to be saved
   * @return the saved CustomerEntity
   */
  @Override
  public Optional<CustomerEntity> saveCustomer(CustomerEntity customerEntity)
  {
    return Optional.of(customerRepository.save(customerEntity));
  }

  @Override
  public boolean customerIsExists(int customerId) {
    return customerRepository.existsById(customerId);
  }

  @Override
  public Optional<CustomerEntity> getCustomer(int customerId){
    return customerRepository.findById(customerId);
  }

  /**
   * Adds an order entity.
   *
   * @param orderEntity the order entity to be added
   * @return the added OrderEntity
   */
  @Override
  public Optional<OrderEntity> addOrder(OrderEntity orderEntity) {
    return Optional.of(orderRepository.save(orderEntity));
  }

  @Override
  public boolean orderIsExists(int orderId) {
    return orderRepository.existsById(orderId);
  }

  /**
   * Retrieves the status of an order given its ID.
   *
   * @param orderId the ID of the order
   * @return the status of the order as an integer
   */
  @Override
  public int getOrderStatus(int  orderId) {
    return orderRepository.findOrderStatusById(orderId);
  }

  @Override
  public Page<OrderEntity> getAllOrdersByCustomerId(int customerId,Pageable pageable){
    return orderRepository.findByCustomerEntityId(customerId,pageable);
  }
}
