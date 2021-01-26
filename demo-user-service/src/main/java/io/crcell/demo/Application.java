package io.crcell.demo;

import io.crcell.pramework.controllable.EnableControllable;
import io.crcell.pramework.eventable.producer.EnableProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@EnableProducer
@EnableControllable
@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
