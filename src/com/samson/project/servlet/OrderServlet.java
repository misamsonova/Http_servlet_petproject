package com.samson.project.servlet;

import com.samson.project.service.OrderService;
import com.samson.project.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/idOrder")
public class OrderServlet extends HttpServlet {

    private final OrderService orderService = OrderService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var orderId = req.getParameter("orderId");
        req.setAttribute("order", orderService.findById(Long.valueOf(orderId)));

        req.getRequestDispatcher(JspHelper.getPath("orders"))
                .forward(req,resp);
    }
}
