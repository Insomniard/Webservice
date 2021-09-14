package com.insomniard.Webservice.commit.controller;

import com.insomniard.Webservice.commit.dto.CommitRegistrationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/board/update")
public class CommitApiController {

    @PostMapping("{boardId}")
    public Long registration(@PathVariable Long boardId, CommitRegistrationDto commitRegistrationDto){
        return 1L;
    }



}
