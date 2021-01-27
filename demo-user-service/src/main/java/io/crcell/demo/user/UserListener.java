package io.crcell.demo.user;

import io.crcell.demo.entities.User;
import io.crcell.simply.eventable.consumer.AbstractConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserListener extends AbstractConsumer<User, Long> {
    protected UserListener() {
        super(User.class);
    }

    @Override
    public User onSave(User entity) {
        log.info("SAVE {}", entity.toString());
        return entity;
    }

    @Override
    public Boolean onDelete(Long aLong) {
        log.info("DELETE {}", aLong);
        return true;
    }
}
