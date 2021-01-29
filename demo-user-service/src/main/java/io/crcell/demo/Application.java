package io.crcell.demo;

import io.crcell.simply.controllable.EnableSimplyControllable;
import io.crcell.simply.eventable.producer.EnableSimplyProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableSimplyProducer
@EnableSimplyControllable
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
