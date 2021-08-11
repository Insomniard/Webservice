package com.insomniard.Webservice.Board.controller;

import com.insomniard.Webservice.Board.dto.ReadDto;
import com.insomniard.Webservice.Board.dto.RegistrationDto;
import com.insomniard.Webservice.Board.dto.updateDto;
import com.insomniard.Webservice.Board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController

public class BoardController {
    private final BoardService boardService;

    @PostMapping("/api/v1/board")
    public Long save(@RequestBody RegistrationDto registrationDto){
        return boardService.save(registrationDto);
    }

    @PutMapping("/api/v1/board/{boardId}")
    public Long update(@PathVariable Long boardId, @RequestBody updateDto dto){
        return boardService.update(boardId, dto);
    }

    @GetMapping("/api/v1/board/{boardId}")
    public ReadDto findById(@PathVariable Long boardId){
        return boardService.findById(boardId);
    }
    @DeleteMapping("api/v1/board/{boardId}")
    public Long delete(@PathVariable Long boardId){
        boardService.delete(boardId);
        return boardId;
    }
}
