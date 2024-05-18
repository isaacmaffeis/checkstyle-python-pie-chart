package org.example.example.domain.mappers;

/**
 * A generic interface for mapping between two types.
 * <p>
 * This interface provides methods to map an object of type {@code A} to an object of type {@code B}
 * and vice versa. It can be used to facilitate the conversion between different layers of an application
 * such as DTOs and entities.
 * </p>
 *
 * @param <A> the source type
 * @param <B> the target type
 */
public interface Mapper<A, B> {

  /**
   * Maps an object of type {@code A} to an object of type {@code B}.
   *
   * @param a the source object to be mapped
   * @return the mapped object of type {@code B}
   */
  B mapEntityToDto(A a);

  /**
   * Maps an object of type {@code B} to an object of type {@code A}.
   *
   * @param b the source object to be mapped
   * @return the mapped object of type {@code A}
   */
  A mapEntityFromDto(B b);

}
