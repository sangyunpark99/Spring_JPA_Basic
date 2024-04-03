package com.example.spring_jpa_basic.chatper7.복합키.복합키_식별관계;

import java.io.Serializable;
import java.util.Objects;

public class GrandChildId implements Serializable {
    private Child child;
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
        return Objects.equals(child, that.child) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(child, id);
    }
}
