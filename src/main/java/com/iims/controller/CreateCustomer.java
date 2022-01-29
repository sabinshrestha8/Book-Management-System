package com.iims.controller;

import com.iims.dao.CustomerDao;
import com.iims.dao.Implement.CustDaoImpl;
import com.iims.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/addCustomer")
public class CreateCustomer extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("customer/addCustomer.jsp");
        rd.forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        String contact = request.getParameter("contact");

        Customer customer = new Customer();
        customer.setName(name);
        customer.setContact(Long.parseLong(contact));

        CustomerDao customerDao = new CustDaoImpl();
        int create = 0;
        try {
            create = customerDao.save(customer);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (create > 0) {
            response.sendRedirect("customer");
        }
    }
}


