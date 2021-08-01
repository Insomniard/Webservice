package com.insomniard.Webservice.Board.dto;

import com.insomniard.Webservice.Board.entity.Board;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReadListDto {

    private Long boardId;
    private String title;
    private String author;
    private LocalDateTime updateTime;

    public ReadListDto(Board entity) {
        this.boardId = entity.getBoardId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.updateTime = entity.getUpdateTime();
    }
}
