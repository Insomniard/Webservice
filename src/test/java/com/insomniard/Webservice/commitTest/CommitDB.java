package com.insomniard.Webservice.commitTest;

import com.insomniard.Webservice.Account.domain.User;
import com.insomniard.Webservice.Account.domain.UserRepository;
import com.insomniard.Webservice.Board.Repository.BoardRepository;
import com.insomniard.Webservice.Board.entity.Board;
import com.insomniard.Webservice.commit.dto.CommitReadDto;
import com.insomniard.Webservice.commit.dto.CommitRegistrationDto;
import com.insomniard.Webservice.commit.entity.Commit;
import com.insomniard.Webservice.commit.repository.CommitRepository;
import com.insomniard.Webservice.commit.service.CommitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CommitDB {
    @Autowired
    private CommitRepository commitRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private CommitService service;

    @Test
    public void 댓글연결이되었나요(){
        LocalDateTime now = LocalDateTime.of(2021, 8, 31, 17, 39);
        Commit commit = Commit.builder()
                .contents("b")
                .author("c")
                .build();
        commitRepository.save(commit);
        List<Commit> list = commitRepository.findAll();
        Commit Time = list.get(0);
        System.out.println("=============================================\n" +
                "registtTime : " + Time.getRegistrationTime() + "\tupdateTime : " + Time.getUpdateTime()
                + "=============================================");
        assertThat(Time.getRegistrationTime().isAfter(now));
        assertThat(Time.getUpdateTime().isAfter(now));

    }

    @Test
    public void 댓테스트(){
        User user = userRepository.findByUserId(1L);
        IntStream.rangeClosed(0, 100).forEach(i ->{
            long boardId = (long)(Math.random() * 100) + 1;
            Board board = boardRepository.findByBoardId(boardId);
            Commit commit = Commit.builder()
                    .contents("test commit" + i)
                    .board(board)
                    .author(user.getName())
                    .build();
            commitRepository.save(commit);
        });
    }

//        @Test
//    public void 게시글모든댓글조회(){
//        Optional<Board> board = boardRepository.findById(60L);
//        List<Commit> test = commitRepository.findByBoardId(60L);
////        Optional<Commit> test2 = commitRepository.findByboardId(test);
//        System.out.println(test);
//    }

    public void 댓글등록컨트롤러테스트(){

    }
    @Test
    public void 특정댓글조회(){
            Optional<Commit> test = commitRepository.findById(22L);
            Commit commit = test.get();
            System.out.println("Commit : " + commit.toString());
    }
    @Test
    public void 댓글등록서비테스트(){
        CommitRegistrationDto dto = CommitRegistrationDto.builder()
                .contents("test 1")
                .author("jjyyong").build();
        Long commitId = service.registration(dto);
    }
//    @Test
//    public void 댓글조회서비스테스트(){
//        CommitReadDto dto = service.findByBoardId(22L);
//        System.out.println(dto);
//    }
//    @Test
//    public void 댓글상세조회서비스테스트(){
//        CommitReadDto dto = commitRepository.getCommitByBoardOrderByBoardId(dt)
//        System.out.println(dto);
//    }


}

