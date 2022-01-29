package com.iims.controller;

import com.iims.dao.BookDao;
import com.iims.dao.Implement.BookDaoImpl;
import com.iims.dao.Implement.SoldBookDaoImpl;
import com.iims.dao.SoldBookDao;
import com.iims.model.Book;
import com.iims.model.SoldBook;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/saleBook")
public class SaleBook extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String book_id = request.getParameter("id");

        if (book_id != null) {

            request.setAttribute("bookId", book_id);
        }

        RequestDispatcher rd = request.getRequestDispatcher("saleBook.jsp");
        rd.forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String book_id = request.getParameter("book_id");
        String customer_id = request.getParameter("customer_id");


        SoldBook soldBook = new SoldBook();
        soldBook.setBook_id(Integer.parseInt(book_id));
        soldBook.setCustomer_id(Integer.parseInt(customer_id));

        SoldBookDao soldBookDao = new SoldBookDaoImpl();
        int create = 0;
        try {
            create = soldBookDao.save(soldBook);

            BookDao bookDao = new BookDaoImpl();

            Book book = bookDao.findOne(Integer.parseInt(book_id));
            book.setStock(book.getStock()-1);
            bookDao.update(book);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (create > 0) {
            response.sendRedirect("sold-book");
        }
    }
}



