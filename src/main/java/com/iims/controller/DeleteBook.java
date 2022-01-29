package com.iims.controller;

import com.iims.dao.BookDao;
import com.iims.dao.Implement.BookDaoImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/delete")
public class DeleteBook extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");

        if (id != null) {
            BookDao bookDao = new BookDaoImpl();
            try {
                System.out.println(id);
                bookDao.delete(Integer.parseInt(id));
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                response.sendRedirect("./");
            }
        }

    }

}
