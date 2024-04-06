package com.example.spring_jpa_basic.chatper7.복합키.EmbeddedId식별관계;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

// 자식 ID

@Entity
public class Child {
    @EmbeddedId
    private ChildId id;

    @MapsId("parentId")
    @ManyToOne
    @JoinColumn(name="PARENT_ID")
    public Parent parent;

    private String name;
}
