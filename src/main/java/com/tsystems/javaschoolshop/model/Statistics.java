package com.tsystems.javaschoolshop.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "statistics")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "S")
public abstract class Statistics implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Statistics() {
    }

}