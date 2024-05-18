package org.example.example.domain.ports;

import static org.assertj.core.api.Assertions.assertThat;

import org.example.example.domain.entities.CustomerEntity;
import org.example.example.domain.entities.OrderEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataPortTests {

  @Autowired
  DataPort dataPort;

  @Test
  void testDataPort(){

    CustomerEntity customerEntity = CustomerEntity.builder().name("name1").build();

    customerEntity = dataPort.saveCustomer(customerEntity);

    assertThat(customerEntity.getName()).isEqualTo("name1");

    OrderEntity orderEntity = OrderEntity.builder().customerEntity(customerEntity).dishId("PIA770").status(0).build();

    assertThat(orderEntity.getDishId()).isEqualTo("PIA770");

    orderEntity = dataPort.addOrder(orderEntity);

    assertThat(dataPort.getOrderStatus(orderEntity.getId())).isEqualTo(0);

  }

}
