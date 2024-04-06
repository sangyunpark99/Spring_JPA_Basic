package com.example.spring_jpa_basic.chatper7.복합키.EmbeddedId식별관계;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GrandChildId implements Serializable {

    private ChildId childId; // @MapsId("childId")로 매핑

    @Column(name = "GRANDCHILD_ID")
    private String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GrandChildId that = (GrandChildId) o;
        return Objects.equals(childId, that.childId) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(childId, id);
    }
}
