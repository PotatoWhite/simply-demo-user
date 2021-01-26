package io.crcell.demo.user;

import io.crcell.demo.entities.User;
import io.crcell.pramework.controllable.ControllableImpl;
import io.crcell.pramework.controllable.ControllableResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllableResponse
@RequestMapping("/users")
public class UserController extends ControllableImpl <User, Long> {
  public UserController(UserService service) {
    super(service);
  }

}
