package com.example.spring_jpa_basic.chatper7.복합키.복합키_Idclass;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ParentTest {

    private final EntityManager em;

    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.setId1("id1");
        parent.setId2("id2");
        parent.setName("James");

    }
}
