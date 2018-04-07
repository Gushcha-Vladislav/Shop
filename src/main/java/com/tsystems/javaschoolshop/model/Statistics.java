package com.tsystems.javaschoolshop.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Base class for all objects with id.Hibernate forces us to make class
 * with fields and getters and setters for all of them, Serializable interface(optional),
 * and empty constructor if we define custom one.
 */
@Entity
@Table(name = "statistics")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_statistics")
public abstract class Statistics implements Serializable {

    /**
     * ID. It generates by hibernate while inserting.
     * This filed connects with id column in all entity table.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Empty constructor for Hibernate.
     */
    public Statistics() {
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