package io.crcell.demo.user;

import io.crcell.demo.entities.User;
import io.easywalk.simply.eventable.producer.SimplyProducer;
import io.easywalk.simply.serviceable.AbstractServiceable;
import org.springframework.stereotype.Service;

@SimplyProducer
@Service
public class UserService extends AbstractServiceable<User, Long> {

    protected UserService(UserRepository repository) {
        super(repository);
    }
}
