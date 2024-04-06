package com.example.spring_jpa_basic.chatper7.복합키.EmbeddedId식별관계;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Parent {

    @Id @Column(name = "PARENT_ID")
    private String id;

    private String name;
}
