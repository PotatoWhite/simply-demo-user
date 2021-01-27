package io.crcell.demo;

import io.crcell.simply.controllable.EnableControllable;
import io.crcell.simply.eventable.consumer.EnableConsumer;
import io.crcell.simply.eventable.producer.EnableProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableProducer
@EnableConsumer
@EnableControllable
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
