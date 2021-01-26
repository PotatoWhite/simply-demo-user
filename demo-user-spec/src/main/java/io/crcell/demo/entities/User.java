package io.crcell.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import io.crcell.pramework.eventable.producer.Eventable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User implements Eventable<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @NotNull
    @Column(unique = true)
    private String email;
}
