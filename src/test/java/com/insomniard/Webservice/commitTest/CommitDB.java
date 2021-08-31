package com.insomniard.Webservice.commitTest;

import com.insomniard.Webservice.commit.entity.Commit;
import com.insomniard.Webservice.commit.repository.CommitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CommitDB {
    @Autowired
    private CommitRepository commitRepository;

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
}

