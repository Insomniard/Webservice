package com.insomniard.Webservice.commit.entity;

import com.insomniard.Webservice.Board.entity.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
public class Commit extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commitId;

    @Column(columnDefinition = "TEXT",nullable = true)
    private String contents;

    private String author;

    @Builder
    public Commit(String title, String contents, String author) {
        this.contents = contents;
        this.author = author;
    }
    public void update(String title, String contents){
        this.contents = contents;
    }
}
