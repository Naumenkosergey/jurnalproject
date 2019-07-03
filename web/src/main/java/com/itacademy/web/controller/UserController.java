package com.itacademy.web.controller;

import com.itacademy.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.itacademy.web.path.UrlPath.USER;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(USER)
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping
    public String getPageUser(Model model){
        model.addAttribute("userhtml",userService.getAllUser());
        return "userhtml";
    }




//    @PostMapping
//    public ModelAndView save(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("usertest");
//
//        return modelAndView;
//    }
}
