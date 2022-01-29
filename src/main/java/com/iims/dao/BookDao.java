package com.iims.dao;

import com.iims.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao{

    int save(Book book) throws SQLException, ClassNotFoundException;

    int update(Book book) throws SQLException, ClassNotFoundException;

    int delete(int id) throws SQLException, ClassNotFoundException;

    List<Book> show () throws SQLException, ClassNotFoundException;

    Book findOne(int id) throws SQLException, ClassNotFoundException;

}
