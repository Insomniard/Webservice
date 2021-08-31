package com.insomniard.Webservice.commit.controller;

import com.insomniard.Webservice.commit.dto.CommitRegistrationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/board/")
public class CommitApiController {

    @PostMapping("{boardId}/registration")
    public Long registration(@PathVariable Long boardId, CommitRegistrationDto commitRegistrationDto){
        return 1L;
    }

}
