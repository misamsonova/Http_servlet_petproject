package com.samson.project.servlet;

import com.samson.project.dao.CarDao;
import com.samson.project.dto.CarDto;
import com.samson.project.entity.Model;
import com.samson.project.service.CarService;
import com.samson.project.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cars")
public class CarServlet extends HttpServlet {
    private final CarService carService = CarService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var models = req.getParameter("modelId");
        req.setAttribute("cars", carService.findAllByModel(models).size());
        req.setAttribute("car", carService.getModelName(models));

        req.getRequestDispatcher(JspHelper.getPath("cars"))
                .forward(req,resp);
    }
}
