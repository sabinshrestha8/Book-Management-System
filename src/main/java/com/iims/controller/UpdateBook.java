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

@WebServlet(urlPatterns = "/update")
public class UpdateBook extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        if (id != null) {
            BookDao bookDao = new BookDaoImpl();
            try {
                Book book = bookDao.findOne(Integer.parseInt(id));
                request.setAttribute("book", book);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
        rd.forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        int stock = Integer.parseInt(request.getParameter("stock"));

        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setAuthor(author);
        book.setStock(stock);

        BookDao bookDao = new BookDaoImpl();
        int update = 0;
        try {
            update = bookDao.update(book);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (update > 0) {
            response.sendRedirect("./");
        }
    }
}


