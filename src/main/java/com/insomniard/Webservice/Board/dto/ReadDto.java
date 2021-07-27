package com.insomniard.Webservice.Board.dto;

import com.insomniard.Webservice.Board.entity.Board;
import lombok.Getter;

@Getter
public class ReadDto {
    private Long boardId;
    private String title;
    private String contents;
    private String author;

    public ReadDto(Board entity) {
        this.boardId = entity.getBoardId();
        this.title = entity.getTitle();
        this.contents = entity.getContents();
        this.author = entity.getAuthor();
    }
}
