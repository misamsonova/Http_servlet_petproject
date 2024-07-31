package com.samson.project.servlet;

import com.samson.project.dto.CreateOrderDto;
import com.samson.project.dto.UserDto;
import com.samson.project.service.CarService;
import com.samson.project.service.ModelService;
import com.samson.project.service.OrderService;
import com.samson.project.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

@MultipartConfig(fileSizeThreshold = 1024 * 1024)
@WebServlet("/create_order")
public class CreateOrderServlet extends HttpServlet {

    private final OrderService orderService = OrderService.getInstance();
    private final ModelService modelService = ModelService.getInstance();
    private final CarService carService = CarService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDto user = (UserDto) session.getAttribute("user");
        req.setAttribute("first_name", user.getFirst_name());
        req.setAttribute("last_name",user.getLast_name());
        req.setAttribute("patronymic", user.getPatronymic());
        req.setAttribute("passport", user.getPassport());
        req.setAttribute("models", modelService.findAll());

        var m = req.getAttribute("models");
//        resp.
        System.out.println(m);
//        System.out.println(carService.findFirstByModel(m).get().getNumber());
//        req.setAttribute("Model: ", );
//        req.setAttribute("Car number: ");
//        req.setAttribute("Price");

        req.getRequestDispatcher(JspHelper.getPath("createOrder"))
                .forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("first_name: " + req.getParameter("first_name"));
        System.out.println("last_name: " + req.getParameter("last_name"));
        System.out.println("patronymic: " + req.getParameter("patronymic"));
        System.out.println("passport: " + req.getParameter("passport"));
        System.out.println("model: " + req.getParameter("model"));
        var m = req.getParameter("model");
        System.out.println("1:" + m);

        var car = carService.findFirstByModel(m);
        System.out.println("car: " + car);

        LocalDateTime now = LocalDateTime.now();
        var orderDto = CreateOrderDto.builder()
                .first_name(req.getParameter("first_name"))
                .last_name(req.getParameter("last_name"))
                .patronymic(req.getParameter("patronymic"))
                .passport(req.getParameter("passport"))
                .model(req.getParameter("model"))
                .number("E102TY")
//                .number(carService.findFirstByModel(req.getParameter("model")).get().getNumber())
                //
                .price("100000")
                //
                .time_order(String.valueOf(now))
                .start_rent(req.getParameter("start_rent"))
                .finish_rent(req.getParameter("finish_rent"))
                .build();

        orderService.create(orderDto);
        resp.sendRedirect("/profile");
    }
}
