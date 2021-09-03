package com.insomniard.Webservice.boardTest;

import com.insomniard.Webservice.Account.domain.User;
import com.insomniard.Webservice.Account.domain.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

    @Test
    public void insertTest(){
        Optional<User> name = userRepository.findById(1L);
        User user = userRepository.findByUserId(1L);
        LocalDateTime now = LocalDateTime.of(2021,07,28,17,39);
        IntStream.rangeClosed(0, 100).forEach(i->{
            Board board = Board.builder()
                    .title("Title Dummy"+i)
                    .contents("Content Dummy"+i)
                    .author(user.getName())
                    .user(user)
                    .build();
            boardRepository.save(board);
            assertThat(board.getRegistrationTime().isAfter(now));
            assertThat(board.getUpdateTime().isAfter(now));

        });
    }

    @Test
    public void Join이되었나요(){
        Optional<Board> test = boardRepository.findById(58L);
        Board board = test.get();
        System.out.println("Board : " + board.toString());
        System.out.println("User : " + board.getUser().toString());
    }

//    @Test
//    public void 연결이되었나요() {
//        LocalDateTime now = LocalDateTime.of(2021, 07, 28, 17, 39);
//        Board board = Board.builder()
//                .title("a")
//                .contents("b")
//                .author("c")
//                .build();
//        boardRepository.save(board);
//        List<Board> list = boardRepository.findAll();
//        Board boardTime = list.get(0);
//        System.out.println("=============================================\n" +
//                "registtTime : " + boardTime.getRegistrationTime() + "\tupdateTime : " + boardTime.getUpdateTime()
//                + "=============================================");
//        assertThat(boardTime.getRegistrationTime().isAfter(now));
//        assertThat(boardTime.getUpdateTime().isAfter(now));
//
//    }

}
