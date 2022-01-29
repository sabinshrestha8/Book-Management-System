package com.iims.controller;

import com.iims.dao.BookDao;
import com.iims.dao.Implement.BookDaoImpl;
import com.iims.model.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/add")
public class CreateBook extends HttpServlet {

        public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            RequestDispatcher rd = request.getRequestDispatcher("add.jsp");
            rd.forward(request, response);

        }

        public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String author = request.getParameter("author");
        int stock = Integer.parseInt(request.getParameter("stock"));

        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setStock(stock);

        BookDao bookDao = new BookDaoImpl();
        int create = 0;
        try {
            create = bookDao.save(book);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (create > 0) {
            response.sendRedirect("./");
        }
    }
}

