package com.samson.project.servlet;

import com.samson.project.dto.CreateUserDto;
import com.samson.project.entity.Role;
import com.samson.project.entity.Gender;
import com.samson.project.exception.ValidationException;
import com.samson.project.service.UserService;
import com.samson.project.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@MultipartConfig(fileSizeThreshold = 1024*1024)
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", Role.values());
        req.setAttribute("genders", Gender.values());

        req.getRequestDispatcher(JspHelper.getPath("registration"))
                .forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var userDto = CreateUserDto.builder()
                .first_name(req.getParameter("first_name"))
                .last_name(req.getParameter("last_name"))
                .patronymic(req.getParameter("patronymic"))
                .birthday(req.getParameter("birthday"))
                .country(req.getParameter("country"))
                .gender(req.getParameter("gender"))
                .passport(req.getParameter("passport"))
                .email(req.getParameter("email"))
                .password(req.getParameter("password"))
                .role(req.getParameter("role"))
                .build();

        try{
            userService.create(userDto);
            resp.sendRedirect("/login");
        } catch(ValidationException exception){
            req.setAttribute("errors", exception.getErrors());
            doGet(req,resp);
        }

    }


}
