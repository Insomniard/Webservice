package com.insomniard.Webservice.boardTest;

import com.insomniard.Webservice.Board.Repository.BoardRepository;
import com.insomniard.Webservice.Board.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class boardDB {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void insertTest(){
        IntStream.rangeClosed(1, 100).forEach(i->{
            Board board = Board.builder()
                    .title("Title test"+i)
                    .contents("Content test"+i)
                    .author("author test"+i)
                    .build();
            System.out.println(boardRepository.save(board));
        });
    }

//    @Test
//    public void 연결이되었나요(){
//        LocalDateTime now = LocalDateTime.of(2021,07,28,17,39);
//        Board board = Board.builder()
//                .title("a")
//                .contents("b")
//                .author("c")
//                .build();
//        boardRepository.save(board);
//        List<Board> list = boardRepository.findAll();
//        Board boardTime = list.get(0);
//        System.out.println("=============================================\n"+
//                            "registtTime : " +boardTime.getRegistrationTime()+"\tupdateTime : "+boardTime.getUpdateTime()
//                            +"=============================================");
////        assertThat(boardTime.getRegistrationTime().isAfter(now));
//        assertThat(boardTime.getUpdateTime().isAfter(now));

    }

