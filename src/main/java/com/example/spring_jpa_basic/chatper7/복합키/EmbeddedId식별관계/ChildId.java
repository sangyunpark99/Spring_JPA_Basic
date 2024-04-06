package com.example.spring_jpa_basic.chatper7.복합키.EmbeddedId식별관계;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ChildId implements Serializable {
    private String parentId; // @MapsId("parentId")로 매핑

    @Column(name = "CHILD_ID")
    private String id;
}
