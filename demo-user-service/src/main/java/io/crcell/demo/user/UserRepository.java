package io.crcell.demo.user;


import io.crcell.demo.entities.User;
import io.crcell.pramework.eventable.producer.repository.ProducibleRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
