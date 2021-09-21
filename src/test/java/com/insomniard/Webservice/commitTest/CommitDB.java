package com.insomniard.Webservice.commitTest;

import com.insomniard.Webservice.Account.domain.User;
import com.insomniard.Webservice.Account.domain.UserRepository;
import com.insomniard.Webservice.Board.Repository.BoardRepository;
import com.insomniard.Webservice.Board.dto.ReadDto;
import com.insomniard.Webservice.Board.entity.Board;
import com.insomniard.Webservice.commit.controller.CommitApiController;
import com.insomniard.Webservice.commit.dto.CommitReadDto;
import com.insomniard.Webservice.commit.dto.CommitRegistrationDto;
import com.insomniard.Webservice.commit.entity.Commit;
import com.insomniard.Webservice.commit.repository.CommitRepository;
import com.insomniard.Webservice.commit.service.CommitService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CommitDB {

    @Autowired
    private CommitRepository commitRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private CommitService service;
    @Autowired
    private TestRestTemplate testRestTemplate;

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
        IntStream.rangeClosed(0, 300).forEach(i ->{
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

    //레이지와 에거의 차이
    //지연로딩과 즉시로딩
    //왠만해서는 지연로딩을 쓴다.
    //왜 와이
    //보드 정보만 필요한데 즉시도링이면 쓸데없이 댓글정까지 다 가져온다.
    //그래서 레이지로 조져놓고 댓글 필요할때만 겟커밋으로 가져오면
    //그떄 쿼리가 또 날라간다. ㅇㅋ ㄱㅅㄱㅅ
    // N+1 문제를 해결하기 위해서 페치조인 fetch join?
    @Test
    @Transactional//여러가지 트렌젝션을 묶어서 롤백도시켜주는 개 혜자 어노테이션
    public void 게시글조회테스트(){
        Optional<Board> optBoard = boardRepository.findById(55L);
        System.out.println(optBoard.isPresent());
        Board board = optBoard.get();
        System.out.println(board.getBoardId());
        List<Commit> commits = board.getCommit();
        System.out.println(commits.toString());

    }

//        @Test
//    public void 게시글모든댓글조회(){
//        Optional<Board> board = boardRepository.findById(60L);
//        List<Commit> test = commitRepository.findByBoardId(60L);
////        Optional<Commit> test2 = commitRepository.findByboardId(test);
//        System.out.println(test);
//    }

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
    @LocalServerPort
    private int port;
    @Test
    public void 댓글등록컨트롤러테스트() throws Exception{
        Long boardId = 8L;
        String content = "controllerTest1";
        String author = "controllerTest1";
        CommitRegistrationDto commitRegistrationDto = CommitRegistrationDto.builder().contents(content).author(author).build();
        String url = "http://localhost:" + 8080 + "/api/v1/board/" + boardId;
        ResponseEntity<Long> responseEntity = testRestTemplate.postForEntity(url,commitRegistrationDto,Long.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(8L);
        List<Commit> all = commitRepository.findAll();
        assertThat(all.get(8).getContents()).isEqualTo(content);
        assertThat(all.get(8).getAuthor()).isEqualTo(author);
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

