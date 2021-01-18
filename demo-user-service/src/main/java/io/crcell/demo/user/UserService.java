package io.crcell.demo.user;

import io.crcell.demo.entities.User;
import io.crcell.pramework.serviceable.ServiceableImpl;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceableImpl<User, Long> {
  protected UserService(UserRepository repository) {
    super(repository);
  }
}
