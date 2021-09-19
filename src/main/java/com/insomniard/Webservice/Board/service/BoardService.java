package com.insomniard.Webservice.Board.service;

import com.insomniard.Webservice.Board.Repository.BoardRepository;
import com.insomniard.Webservice.Board.dto.ReadDto;
import com.insomniard.Webservice.Board.dto.ReadListDto;
import com.insomniard.Webservice.Board.dto.RegistrationDto;
import com.insomniard.Webservice.Board.dto.updateDto;
import com.insomniard.Webservice.Board.entity.Board;
import com.insomniard.Webservice.commit.dto.CommitReadDto;
import com.insomniard.Webservice.commit.entity.Commit;
import com.insomniard.Webservice.commit.repository.CommitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final CommitRepository commitRepository;

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
        List<CommitReadDto> commits = boardRepository.findById(boardId).get().getCommit().stream().map(commit -> new CommitReadDto(commit)).collect(Collectors.toList());
        return new ReadDto(entity, commits);
    }

    @Transactional(readOnly = true)
    public List<ReadListDto> findAllDesc(Pageable pageable){
        return boardRepository.findFirst20ByOrderByBoardIdDesc(pageable).stream().map(board -> new ReadListDto(board)).collect(Collectors.toList());

    }

    @Transactional
    public void delete(Long boardId){
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다. No = " +boardId));
        boardRepository.delete(board);
    }

}
