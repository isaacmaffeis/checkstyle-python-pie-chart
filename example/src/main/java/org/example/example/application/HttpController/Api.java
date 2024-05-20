package org.example.example.application.HttpController;

import java.util.List;
import java.util.Optional;
import org.example.example.domain.dto.CustomerDto;
import org.example.example.domain.dto.OrderDto;
import org.example.example.domain.ports.AppPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller implementing the API interface for managing customers and orders.
 */
@RestController
public class Api implements ApiIF{

  private final AppPort appPort;

  /**
   * Constructor to inject the application port.
   *
   * @param appPort the application port to be injected
   */
  @Autowired
  public Api(AppPort appPort) {
      this.appPort = appPort;
  }

  @Override
  public ResponseEntity<CustomerDto> addNewCustomer(String name) {
    CustomerDto customerDto = CustomerDto.builder().name(name).build();
    Optional<CustomerDto> savedCustomerDto = appPort.addNewCustomerToDb(customerDto);
    return savedCustomerDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
  }

  @Override
  public ResponseEntity<OrderDto> addNewOrder(int customerId, String dishId) {
    Optional<CustomerDto> customerDto = appPort.getCustomer(customerId);
    if (customerDto.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    OrderDto orderDto = OrderDto.builder().customerDto(customerDto.get()).dishId(dishId).build();
    Optional<OrderDto> savedOrderDto = appPort.addNewOrderToDb(orderDto);
    return savedOrderDto.map(dto -> (new ResponseEntity<>(dto, HttpStatus.OK)))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
  }

  @Override
  public ResponseEntity<Integer> getOrderStatus(int orderId) {
    Optional<Integer> res = appPort.getOrderStatusFromDb(orderId);
    return res.map(Value -> (new ResponseEntity<>(Value, HttpStatus.OK)))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @Override
  public ResponseEntity<Page<OrderDto>> getAllOrdersByCustomer(int customerId, Pageable pageable) {
    Optional<Page<OrderDto>> res = appPort.getAllOrderByCustomer(customerId, pageable);
    return res.map(page -> (new ResponseEntity<>(page, HttpStatus.OK))).
        orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
