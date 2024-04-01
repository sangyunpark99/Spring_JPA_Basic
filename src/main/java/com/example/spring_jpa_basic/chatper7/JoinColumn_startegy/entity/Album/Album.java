package com.example.spring_jpa_basic.chatper7.JoinColumn_startegy.entity.Album;

import com.example.spring_jpa_basic.chatper7.JoinColumn_startegy.entity.Item.Item;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Album extends Item {
    private String artist;
}
