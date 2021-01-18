package io.crcell.demo.user;


import io.crcell.demo.entities.User;
import io.crcell.pramework.eventable.producer.repository.ProducibleRepository;

public interface UserRepository extends ProducibleRepository<User, Long> {}
