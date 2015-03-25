package com.davidoladeji.park.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Daveola on 2/24/2015.
 */


@Entity(name = "space_type")
@Table(name = "space_type")
public class SpaceType implements Serializable {

    // @PersistenceContext(type = PersistenceContextType.EXTENDED)

    private static final long serialVersionUID = 3448440238142761023L;

    @OneToMany
    List<CarparkSpace> carparkSpace;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Basic
    @Column(name = "name")
    private String name;

    public SpaceType() {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpaceType)) return false;

        SpaceType spaceType = (SpaceType) o;

        if (carparkSpace != null ? !carparkSpace.equals(spaceType.carparkSpace) : spaceType.carparkSpace != null)
            return false;
        if (!id.equals(spaceType.id)) return false;
        if (name != null ? !name.equals(spaceType.name) : spaceType.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = carparkSpace != null ? carparkSpace.hashCode() : 0;
        result = 31 * result + id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
