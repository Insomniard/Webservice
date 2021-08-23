package com.insomniard.Webservice.Board.dto;

import com.insomniard.Webservice.Board.Repository.BoardRepository;
import com.insomniard.Webservice.Board.entity.Board;
import org.springframework.data.domain.*;

import java.util.ArrayList;
import java.util.List;

public class PagingDto {
    public int getBoardSize(String boardType, BoardRepository boardRepository, String searchType, String keyword){
        List<Board> boardSize = new ArrayList<>();
        int totalPage;
        int elementsSize;
        elementsSize = 20;

        totalPage = boardSize.size() / elementsSize;

        if(boardSize.size() % elementsSize != 0) totalPage++;

        return totalPage;
    }
}
