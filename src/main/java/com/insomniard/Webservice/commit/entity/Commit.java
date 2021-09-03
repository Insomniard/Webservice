package com.insomniard.Webservice.commit.entity;

import com.insomniard.Webservice.Account.domain.User;
import com.insomniard.Webservice.Board.entity.BaseEntity;
import com.insomniard.Webservice.Board.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
@ToString
public class Commit extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commitId;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String contents;

    private String author;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Builder
    public Commit(Board board, String title, String contents, String author) {
        this.contents = contents;
        this.author = author;
        this.board = board;
    }
    public void update(String title, String contents){
        this.contents = contents;
    }
}
