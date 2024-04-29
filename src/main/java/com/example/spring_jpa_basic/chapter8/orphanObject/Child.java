package com.example.spring_jpa_basic.chapter8.orphanObject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Child {
    @Id @GeneratedValue
    private Long id;


}
