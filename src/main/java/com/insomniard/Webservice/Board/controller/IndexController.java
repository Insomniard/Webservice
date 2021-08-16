package com.insomniard.Webservice.Board.controller;

import com.insomniard.Webservice.Board.dto.ReadDto;
import com.insomniard.Webservice.Board.service.BoardService;
import com.insomniard.Webservice.config.auth.LoginUser;
import com.insomniard.Webservice.config.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final BoardService boardService;

    @GetMapping("/")
    public String index(Model model,@LoginUser SessionUser user){
        if(user != null){
            System.out.println("넘어갔");
            readpage(model,user);
            return "readpage";
        }
        else return "index";
    }
    @GetMapping("/readpage")
    public String readpage(Model model,@LoginUser SessionUser user){
        model.addAttribute("userName",user.getName());
        model.addAttribute("board",boardService.findAllDesc());
        return "readpage";
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
        model.addAttribute("board",dto);
        return "boardUpdate";
    }


}
