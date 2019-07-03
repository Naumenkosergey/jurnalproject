package com.itacademy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.itacademy.web.path.UrlPath.ADMIN;

@Controller
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(ADMIN)
public class AdminController {

//    private final IUserService userService;

    @GetMapping
    public String getPageAdmin(){
        return "profilhtml";
    }

}
