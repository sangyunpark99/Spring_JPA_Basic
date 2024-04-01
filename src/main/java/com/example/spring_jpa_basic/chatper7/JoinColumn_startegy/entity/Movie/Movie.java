package com.example.spring_jpa_basic.chatper7.JoinColumn_startegy.entity.Movie;

import com.example.spring_jpa_basic.chatper7.JoinColumn_startegy.entity.Item.Item;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("M")
public class Movie extends Item {
    private String director; // 감독
    private String actor; // 배우
}
