package com.example.spring_jpa_basic.chatper7.JoinColumn_startegy.MappedSuperclass;

import jakarta.persistence.Entity;

@Entity
public class Member extends BaseEntity {
    private String email;
}
