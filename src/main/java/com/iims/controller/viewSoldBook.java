package com.iims.controller;

import com.iims.dao.Implement.SoldBookDaoImpl;
import com.iims.dao.SoldBookDao;
import com.iims.model.SoldBook;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/sold-book")
public class viewSoldBook extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SoldBookDao soldBookDao = new SoldBookDaoImpl();

        try {
            request.setAttribute("soldBooks", soldBookDao.show());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = request.getRequestDispatcher("viewSoldBook.jsp");
        rd.forward(request, response);

    }
}


