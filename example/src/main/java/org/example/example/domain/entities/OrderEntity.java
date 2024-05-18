package org.example.example.domain.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an order placed by a customer.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class OrderEntity {

  /**
   * The unique identifier for the order. This is a primary key and is auto-generated.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  /**
   * The unique identifier of the customer who placed the order.
   */
  @ManyToOne()
  @JoinColumn(name = "customer_id")
  private CustomerEntity customerEntity;

  /**
   * The identifier of the dish ordered.
   */
  private String dishId;

  /**
   * The status of the order.
   * <p>
   * This field might represent the following different states of the order: 0: order not placed
   * yet; 1: order placed; 2: order in preparation; 3: order prepared.
   * </p>
   */
  private int status;

  /**
   * The timestamp when the order was created or last updated.
   */
  private Timestamp timestamp;

}
