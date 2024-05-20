package org.example.example.infrastructure.repository.repositories;

import org.example.example.domain.entities.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface for accessing and managing customer data.
 * <p>
 * This interface extends {@link CrudRepository},
 * providing basic CRUD (Create, Read, Update, Delete) operations
 * for {@link CustomerEntity} objects with integer identifiers.
 * </p>
 */
public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {

}
