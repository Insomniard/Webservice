package com.insomniard.Webservice.Board.service;

import com.insomniard.Webservice.Board.Repository.BoardRepository;
import com.insomniard.Webservice.Board.dto.ReadDto;
import com.insomniard.Webservice.Board.dto.ReadListDto;
import com.insomniard.Webservice.Board.dto.RegistrationDto;
import com.insomniard.Webservice.Board.dto.updateDto;
import com.insomniard.Webservice.Board.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Long save(RegistrationDto registrationDto){
        return boardRepository.save(registrationDto.toEntity()).getBoardId();
    }

    @Transactional
    public Long update(Long boardId, updateDto dto){
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다. No = " +boardId));
        board.update(dto.getTitle(), dto.getContents());
        return boardId;
    }
    public ReadDto findById (Long boardId){
        Board entity = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다. No = " +boardId));
        return new ReadDto(entity);
    }
    @Transactional(readOnly = true)
    public List<ReadListDto> findAllDesc(){
        return boardRepository.findAllDesc().stream().map(board -> new ReadListDto(board)).collect(Collectors.toList());

    }
}
