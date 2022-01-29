package com.iims.controller;

import com.iims.dao.CustomerDao;
import com.iims.dao.Implement.CustDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/customer")
public class ViewCustomer extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CustomerDao CustomerDao = new CustDaoImpl();

        try {
            request.setAttribute("customers", CustomerDao.show());
            System.out.println("hi");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = request.getRequestDispatcher("customer/viewCustomer.jsp");
        rd.forward(request, response);

    }
}

