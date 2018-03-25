package com.tsystems.javaschoolshop.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "statistics")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_statistics")
public abstract class Statistics implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Statistics() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}