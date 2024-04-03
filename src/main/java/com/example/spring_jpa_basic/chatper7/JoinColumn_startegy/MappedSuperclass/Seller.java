package com.example.spring_jpa_basic.chatper7.JoinColumn_startegy.MappedSuperclass;

import jakarta.persistence.Entity;

@Entity
public class Seller extends BaseEntity{
    private String shopName;
}
