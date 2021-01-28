package io.crcell.demo.user;

import io.crcell.demo.entities.User;
import io.crcell.simply.serviceable.AbstractServiceable;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractServiceable<User, Long> {

    protected UserService(UserRepository repository) {
        super(repository);
    }
}
