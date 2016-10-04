package me.jetmoney.entity;

import javax.persistence.*;

/**
 * Created by Denis Murzin
 *      on 26.09.16.
 */
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) // TODO: 05.10.16 переделать на IDENTITY
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
