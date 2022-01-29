package com.iims.controller;

import com.iims.dao.BookDao;
import com.iims.dao.Implement.BookDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/")
public class GetBooks extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BookDao bookDao = new BookDaoImpl();

        try {
            request.setAttribute("books", bookDao.show());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = request.getRequestDispatcher("homepage.jsp");
        rd.forward(request, response);

    }
}
