package io.crcell.demo.user;

import io.crcell.demo.entities.User;
import io.crcell.simply.eventable.consumer.AbstractSimplyConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserListener extends AbstractSimplyConsumer<User, Long> {
    protected UserListener() {
        super(User.class);
    }

    @Override
    public User onSave(String key, User entity) {
        log.info("SAVE {}", entity.toString());
        return entity;
    }

    @Override
    public Boolean onDelete(String key) {
        log.info("DELETE {}", key);
        return null;
    }
}
