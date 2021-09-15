package com.insomniard.Webservice.Board.dto;

import com.insomniard.Webservice.Board.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegistrationDto {
    private String title;
    private String contents;
    private String author;

    @Builder
    public RegistrationDto(String title, String contents, String author) {
        this.title = title;
        this.contents = contents;
        this.author = author;
    }


    public Board toEntity(){
        return Board.builder()
                .title(title)
                .contents(contents)
                .author(author)
                .build();
    }

}
