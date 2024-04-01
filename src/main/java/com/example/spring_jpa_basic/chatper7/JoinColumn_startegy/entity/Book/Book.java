package com.example.spring_jpa_basic.chatper7.JoinColumn_startegy.entity.Book;

import com.example.spring_jpa_basic.chatper7.JoinColumn_startegy.entity.Item.Item;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("B")
@PrimaryKeyJoinColumn(name = "BOOK_ID")
public class Book extends Item {
    private String author; // 작가
    private String isbn; // ISBN
}
