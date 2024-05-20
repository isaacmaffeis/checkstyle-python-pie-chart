package org.example.example.infrastructure.repository.repositories;

import org.example.example.domain.entities.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Repository interface for accessing and managing order data.
 * <p>
 * This interface extends {@link CrudRepository},
 * providing basic CRUD (Create, Read, Update, Delete) operations
 * for {@link OrderEntity} objects with integer identifiers.
 * </p>
 */
public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {

  /**
   * Retrieves the status of an order given its ID using a custom JPQL query.
   *
   * @param orderId the ID of the order
   * @return the status of the order as an integer
   */
  @Query("SELECT o.status FROM OrderEntity o WHERE o.id = ?1")
  int findOrderStatusById(int orderId);

  // Query method based on conventions
  Page<OrderEntity> findByCustomerEntityId(int customerId, Pageable pageable);

  // query JPQL
  @Query("SELECT o FROM OrderEntity o WHERE o.customerEntity.id = :customerId")
  Page<OrderEntity> findOrdersByCustomerId(@Param("customerId") int customerId, Pageable pageable);

}
