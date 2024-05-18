package org.example.example;

import org.example.example.domain.entities.CustomerEntity;
import org.example.example.domain.entities.OrderEntity;
import org.example.example.domain.ports.DataPort;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ExampleApplication {

  public static void main(String[] args) throws InterruptedException {
    SpringApplication.run(ExampleApplication.class, args);
  }


}
