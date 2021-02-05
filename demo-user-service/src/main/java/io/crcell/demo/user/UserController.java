package io.crcell.demo.user;

import io.crcell.demo.entities.User;
import io.crcell.simply.controllable.AbstractControllable;
import io.crcell.simply.controllable.SimplyControllableResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SimplyControllableResponse
@RequestMapping("/users")
public class UserController extends AbstractControllable<User, Long> {
    public UserController(UserService service) {
        super(service);
    }

}
