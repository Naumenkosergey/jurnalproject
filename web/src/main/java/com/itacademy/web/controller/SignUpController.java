package com.itacademy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/signup")
public class SignUpController {

//    @Autowired
//    private UserRepository userRepository;

    @GetMapping("/signup")
    public String getSignUp() {
        return "signup";
    }

//    @PostMapping("/signup")
//    public String addUser(User user)  {
//        Optional<User> userByLogin = userRepository.findByLogin(user.getLogin());
//        if (userByLogin.isPresent()){
//            return "signup";
//        }
//        user.setLogin("naymchik");
//        user.setPassword("password");
//        userRepository.save(user);
//        return "redirect:/login";
//    }
}
