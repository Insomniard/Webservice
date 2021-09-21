package com.insomniard.Webservice.commit.controller;

import com.insomniard.Webservice.Board.dto.ReadDto;
import com.insomniard.Webservice.Board.dto.ReadListDto;
import com.insomniard.Webservice.Board.service.BoardService;
import com.insomniard.Webservice.commit.dto.CommitReadDto;
import com.insomniard.Webservice.commit.dto.CommitRegistrationDto;
import com.insomniard.Webservice.commit.service.CommitService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/board")

public class CommitApiController {
    private final CommitService commitService;
    @PostMapping("/{boardId}")
    public Long registration(@PathVariable Long boardId, @PathVariable Long commitId, @RequestBody CommitRegistrationDto commitRegistrationDto){
        return commitService.registration(commitRegistrationDto);
    }

}
