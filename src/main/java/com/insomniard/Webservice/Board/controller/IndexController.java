package com.insomniard.Webservice.Board.controller;

import com.insomniard.Webservice.Board.dto.ReadDto;
import com.insomniard.Webservice.Board.service.BoardService;
import com.insomniard.Webservice.commit.dto.CommitReadDto;
import com.insomniard.Webservice.commit.service.CommitService;
import com.insomniard.Webservice.config.auth.LoginUser;
import com.insomniard.Webservice.config.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final BoardService boardService;
    private final CommitService commitService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user, @PageableDefault(size = 20,sort = "boardId",direction = Sort.Direction.DESC)Pageable pageable){
        if(user == null){
            return "loginBoard";
        }
        else{
            model.addAttribute("userName",user.getName());
            model.addAttribute("board",boardService.findAllDesc(pageable));
            return "index";
        }
    }

    @GetMapping("/loginBoard")
    public String loginBoard(){
        return "loginBoard";
    }

    @GetMapping("/board/registration")
    public String registration(){
        return "boardRegistration";
    }
    @GetMapping("board/update/{boardId}")
    public String update(@PathVariable Long boardId, Model model){
        ReadDto dto = boardService.findById(boardId);
//        CommitReadDto commitReadDto = commitService.f
        model.addAttribute("board",dto);
//        model.addAttribute("commit",commitService)
        return "boardUpdate";
    }
}
