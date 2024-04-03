package com.example.spring_jpa_basic.chatper7.복합키.복합키_embeddedId;

import com.example.spring_jpa_basic.chatper7.복합키.복합키_Idclass.ParentId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Parent {
    @EmbeddedId
    private ParentId id;
    private String name;
}
