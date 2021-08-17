package com.insomniard.Webservice.Board.Repository;

import com.insomniard.Webservice.Board.entity.Board;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {
//    @Query("SELECT b FROM Board b ORDER BY b.boardId DESC ")
    List<Board> findFirst20ByOrderByBoardIdDesc(Pageable pageable);
}
