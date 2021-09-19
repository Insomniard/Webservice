package com.insomniard.Webservice.Board.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class updateDto {
    private String title;
    private String contents;

    @Builder
    public updateDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

}
