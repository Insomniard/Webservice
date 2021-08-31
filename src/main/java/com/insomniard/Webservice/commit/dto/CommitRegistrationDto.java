package com.insomniard.Webservice.commit.dto;

import com.insomniard.Webservice.Board.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommitRegistrationDto {

    private String contents;
    private String author;

    @Builder
    public CommitRegistrationDto(String title, String contents, String author) {
        this.contents = contents;
        this.author = author;
    }

    public Board toEntity(){
        return Board.builder()
                .contents(contents)
                .author(author)
                .build();
    }
}
