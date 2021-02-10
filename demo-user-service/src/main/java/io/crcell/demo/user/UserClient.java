package io.crcell.demo.user;

import io.crcell.demo.entities.User;
import io.easywalk.simply.clientable.AbstractClientable;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class UserClient extends AbstractClientable<User, Long> {

    public UserClient() {
        super(User.class, WebClient.builder()
                                   .baseUrl("http://localhost:8080/users")
                                   .build());
    }
}
