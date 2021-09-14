package com.insomniard.Webservice.commit.dto;

import com.insomniard.Webservice.Board.entity.Board;
import com.insomniard.Webservice.commit.entity.Commit;
import lombok.Getter;

@Getter
public class CommitReadDto {
    private Long commitId;
    private String contents;
    private String author;

    public CommitReadDto(Commit entity) {
        this.commitId = entity.getCommitId();
        this.contents = entity.getContents();
        this.author = entity.getAuthor();
    }
}
