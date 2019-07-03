package com.itacademy.web.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

//    private final IUserService userService = new IUserService();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<User> allUsers = userService.findAllUsers();
//        req.setAttribute("users", allUsers);
//
//        getServletContext()
//                .getRequestDispatcher("/WEB-INF/jsp/usertest.jsp")
//                .forward(req, resp);
//    }
}
