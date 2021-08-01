package com.insomniard.Webservice.Board.controller;

import com.insomniard.Webservice.Board.Repository.BoardRepository;
import com.insomniard.Webservice.Board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@RequiredArgsConstructor
@Controller
public class IndexController {
    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("board",boardService.findAllDesc());
        return "index";
    }
    @GetMapping("/board/registration")
    public String registration(){
        return "boardRegistration";
    }


}
