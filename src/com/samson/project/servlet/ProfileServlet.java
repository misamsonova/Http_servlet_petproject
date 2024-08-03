package com.samson.project.servlet;

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
import java.io.PrintWriter;
import java.util.List;

@MultipartConfig(fileSizeThreshold = 1024 * 1024)
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private final OrderService orderService = OrderService.getInstance();
    private final ModelService modelService = ModelService.getInstance();
    private final CarService carService = CarService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDto user = (UserDto) session.getAttribute("user");
        List order = orderService.findByPassport(user.getPassport());
        req.setAttribute("order", order);

        resp.setContentType("text/plain");
        resp.setHeader("Content-Disposition", "attachment;filename=cars.txt");

        try (PrintWriter writer = resp.getWriter()) {
            writer.println("ID: " + order.get(0) + ", First name: " + order.get(2)  + ", Last name: " + order.get(3) );
        }

        req.getRequestDispatcher(JspHelper.getPath("createOrder"))
                .forward(req,resp);
    }
}
