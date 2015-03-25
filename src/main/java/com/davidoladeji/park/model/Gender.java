package com.davidoladeji.park.model;

import com.davidoladeji.park.model.Account;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Daveola on 3/1/2015.
 */


@Entity(name = "gender")
@Table(name = "gender")
public class Gender implements Serializable {

    private static final long serialVersionUID = -5862755730050842484L;

    @OneToMany
    List<Account> account;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Basic
    @Column
    private String name;

    public Gender() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
