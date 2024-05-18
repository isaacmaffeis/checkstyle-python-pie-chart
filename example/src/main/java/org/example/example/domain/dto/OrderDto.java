package org.example.example.domain.dto;

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
public class OrderDto {

  /**
   * The unique identifier for the order.
   */
  private int id;

  /**
   * The unique identifier of the customer who placed the order.
   */
  private CustomerDto customerDto;

  /**
   * The identifier of the dish ordered.
   */
  private String dishId;

  /**
   * The status of the order.
   * <p>
   * This field might represent the following different states of the order:
   * </p>
   * <p>0: order not placed yet;</p>
   * <p>1: order placed;</p>
   * <p>2: order in preparation;</p>
   * <p>3: order prepared.</p>
   *
   */
  private int status;

  /**
   * The timestamp when the order was created or last updated.
   */
  private Timestamp timestamp;

}
