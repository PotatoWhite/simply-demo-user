package io.crcell.demo.user;


import io.crcell.demo.entities.User;
import io.easywalk.simply.eventable.producer.ProducibleRepository;


public interface UserRepository extends ProducibleRepository<User, Long> {
}
