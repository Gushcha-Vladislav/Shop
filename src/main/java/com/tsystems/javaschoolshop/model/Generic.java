package com.tsystems.javaschoolshop.model;


import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class Generic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
}
