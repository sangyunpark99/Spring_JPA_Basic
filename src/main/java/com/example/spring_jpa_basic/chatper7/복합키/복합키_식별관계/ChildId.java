package com.example.spring_jpa_basic.chatper7.복합키.복합키_식별관계;

import java.io.Serializable;
import java.util.Objects;

public class ChildId implements Serializable {

    private String parent;
    private String childId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChildId childId1 = (ChildId) o;
        return Objects.equals(parent, childId1.parent) && Objects.equals(childId, childId1.childId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent, childId);
    }
}
