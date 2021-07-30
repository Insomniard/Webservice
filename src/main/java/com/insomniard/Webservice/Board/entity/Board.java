package com.insomniard.Webservice.Board.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
public class Board extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT",nullable = true)
    private String contents;

    private String author;

    @Builder
    public Board(String title, String contents, String author) {
        this.title = title;
        this.contents = contents;
        this.author = author;
    }
    public void update(String title, String contents){
        this.title = title;
        this.contents = contents;
    }
}
