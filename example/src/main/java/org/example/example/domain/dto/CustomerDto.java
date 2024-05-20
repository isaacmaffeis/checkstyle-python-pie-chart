package org.example.example.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents the dto of a customer.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {

  /**
   * The unique identifier for the customer.
   */
  private int id;

  /**
   * The name of the customer.
   */
  private String name;

}
