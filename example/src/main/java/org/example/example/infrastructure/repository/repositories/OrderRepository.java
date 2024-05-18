package org.example.example.infrastructure.repository.repositories;

import org.example.example.domain.entities.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

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

}
