package com.example.servletytpo;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CarResultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> cars = (List<Car>) req.getAttribute("cars");
        req.setAttribute("cars", cars);
        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }
}
