package com.samson.project.servlet;

import com.samson.project.dao.ModelDao;
import com.samson.project.dto.UserDto;
import com.samson.project.entity.Model;
import com.samson.project.entity.User;
import com.samson.project.service.ModelService;
import com.samson.project.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet("/models")
public class ModelServlet extends HttpServlet {

    private final ModelService modelService = ModelService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDto user = (UserDto) session.getAttribute("user");
        System.out.println(user);

        req.setAttribute("models", modelService.findAll());

        req.getRequestDispatcher(JspHelper.getPath("models"))
                .forward(req,resp);

//        List<Model> models = ModelDao.findAllStatic();
//        req.setAttribute("models", models);
//
//        getServletContext().getRequestDispatcher(JspHelper.getPath("models")).forward(req,resp);
    }

}
