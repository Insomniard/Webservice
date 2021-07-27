package com.insomniard.Webservice.boardTest;

import com.insomniard.Webservice.Board.Repository.BoardRepository;
import com.insomniard.Webservice.Board.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class boardDB {
//    @Autowired
//    private BoardRepository boardRepository;
//
//    @Test
//    public void insertTest(){
//        IntStream.rangeClosed(1, 100).forEach(i->{
//            Board board = Board.builder()
//                    .title("Title test"+i)
//                    .contents("Content test"+i)
//                    .author("author test"+i)
//                    .build();
//            System.out.println(boardRepository.save(board));
//        });
//    }
}
