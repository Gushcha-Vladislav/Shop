package com.tsystems.javaschoolshop.model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Generic mapped superclass. This is the parent class for all entities to add the column 'id'.
 * Hibernate forces us to make class
 * with fields and getters and setters for all of them, Serializable interface(optional),
 * and empty constructor if we define custom one.
 */
@MappedSuperclass
public abstract class Generic implements Serializable {

    /**
     * ID. It generates by hibernate while inserting.
     * This filed connects with id column in all entity table.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * Empty constructor for Hibernate.
     */
    public Generic(){
        //Empty constructor for hibernate.
    }
    /**
     * Simple getter
     * @return ID value
     */
    public Integer getId() {
        return id;
    }

    /**
     * Simple setter
     * @param id is value to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
}
