package com.davidoladeji.park.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Daveola on 2/20/2015.
 */
@Entity(name = "role")
@Table(name = "role")
public class Role implements Serializable {

    // @PersistenceContext(type = PersistenceContextType.EXTENDED)

    private static final long serialVersionUID = -7391091350329083563L;

    @OneToMany
    List<Account> account;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    @Column(name = "rolename")
    private String name;
    @Basic
    @Column(name = "codename")
    private String codeName;

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String rolename) {
        this.name = rolename;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codename) {
        this.codeName = codename;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        Role role = (Role) o;

        if (id != role.id) return false;
        if (account != null ? !account.equals(role.account) : role.account != null) return false;
        if (codeName != null ? !codeName.equals(role.codeName) : role.codeName != null) return false;
        if (name != null ? !name.equals(role.name) : role.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = account != null ? account.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (codeName != null ? codeName.hashCode() : 0);
        return result;
    }
}
