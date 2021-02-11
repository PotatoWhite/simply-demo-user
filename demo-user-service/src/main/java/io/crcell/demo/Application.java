package io.crcell.demo;

import io.easywalk.simply.controllable.EnableSimplyControllable;
import io.easywalk.simply.eventable.kafka.producer.EnableSimplyProducer;
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
