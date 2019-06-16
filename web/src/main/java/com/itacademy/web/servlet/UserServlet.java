package com.itacademy.web.servlet;

import com.itacademy.database.entity.User;
import com.itacademy.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> allUsers = userService.findAllUsers();
        req.setAttribute("users", allUsers);

        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/user.jsp")
                .forward(req, resp);
    }
}
