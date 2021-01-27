package io.crcell.demo.user;


import io.crcell.demo.entities.User;
import io.crcell.simply.eventable.producer.repository.ProducibleRepository;

public interface UserRepository extends ProducibleRepository<User, Long> {
}
