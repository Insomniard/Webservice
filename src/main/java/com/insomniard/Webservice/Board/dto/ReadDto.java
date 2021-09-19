package com.insomniard.Webservice.Board.dto;

import com.insomniard.Webservice.Board.entity.Board;
import com.insomniard.Webservice.commit.dto.CommitReadDto;
import com.insomniard.Webservice.commit.entity.Commit;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ReadDto {
    private Long boardId;
    private String title;
    private String contents;
    private String author;
    private List<CommitReadDto> commits;

    public ReadDto(Board entity, List<CommitReadDto> commits) {
        this.boardId = entity.getBoardId();
        this.title = entity.getTitle();
        this.contents = entity.getContents();
        this.author = entity.getAuthor();
        this.commits = commits;
    }
}
