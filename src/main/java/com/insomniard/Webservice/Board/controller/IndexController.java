package com.insomniard.Webservice.Board.controller;

import com.insomniard.Webservice.Board.Repository.BoardRepository;
import com.insomniard.Webservice.Board.dto.ReadDto;
import com.insomniard.Webservice.Board.service.BoardService;
import com.insomniard.Webservice.config.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final BoardRepository boardRepository;
    private final BoardService boardService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("board",boardService.findAllDesc());
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName",user.getName());
        }
        return "index";
    }
    @GetMapping("/board/registration")
    public String registration(){
        return "boardRegistration";
    }
    @GetMapping("board/update/{boardId}")
    public String update(@PathVariable Long boardId, Model model){
        ReadDto dto = boardService.findById(boardId);
        model.addAttribute("board",dto);
        return "boardUpdate";
    }


}
