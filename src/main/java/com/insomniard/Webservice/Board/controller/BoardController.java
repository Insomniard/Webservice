package com.insomniard.Webservice.Board.controller;

import com.insomniard.Webservice.Board.dto.ReadDto;
import com.insomniard.Webservice.Board.dto.ReadListDto;
import com.insomniard.Webservice.Board.dto.RegistrationDto;
import com.insomniard.Webservice.Board.dto.updateDto;
import com.insomniard.Webservice.Board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping("")
    public Long save(@RequestBody RegistrationDto registrationDto){
        return boardService.save(registrationDto);
    }

    @PutMapping("/{boardId}")
    public Long update(@PathVariable Long boardId, @RequestBody updateDto dto){
        return boardService.update(boardId, dto);
    }

    @GetMapping("/{boardId}")
    public ReadDto findById(@PathVariable Long boardId){
        return boardService.findById(boardId);
    }

    @GetMapping("/readpage")
    public List<ReadListDto> findAllDesc(Pageable pageable){
        return boardService.findAllDesc(pageable);
    }

    @DeleteMapping("/{boardId}")
    public Long delete(@PathVariable Long boardId){
        boardService.delete(boardId);
        return boardId;
    }
}
