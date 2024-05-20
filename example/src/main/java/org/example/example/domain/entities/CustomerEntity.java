package org.example.example.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a customer.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "customers")
public class CustomerEntity {

  /**
   * The unique identifier for the customer. This is a primary key and is auto-generated.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  /**
   * The name of the customer.
   */
  private String name;

}
