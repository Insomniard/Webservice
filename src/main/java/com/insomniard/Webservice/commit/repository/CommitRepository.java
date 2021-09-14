package com.insomniard.Webservice.commit.repository;

import com.insomniard.Webservice.Board.entity.Board;
import com.insomniard.Webservice.commit.entity.Commit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;
@EnableJpaAuditing
public interface CommitRepository extends JpaRepository<Commit, Long> {
//    @Modifying
//    @Query("delete from Commit c where c.board.boardId = :boardId")
//    void deleteByBoardId(Long boardId);
//
//    List<Commit> getCommitByBoardOrderByBoardId(Commit commit);
//    List<Commit> findByBoardId(Long boardId);

}
