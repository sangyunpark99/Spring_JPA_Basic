package com.example.spring_jpa_basic.chatper7.JoinColumn_startegy.MappedSuperclass;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
    @Id @GeneratedValue
    private Long id;
    private String name;
}
