package com.iims.dao.Implement;

import com.iims.dao.BookDao;
import com.iims.database.ConnectionFactory;
import com.iims.model.Book;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    ConnectionFactory db = new ConnectionFactory();

    public int save(Book book) throws SQLException, ClassNotFoundException {

        Connection conn = db.connect();

        String sql = "INSERT INTO Books (name, author, stock) VALUES (?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, book.getName());
        statement.setString(2, book.getAuthor());
        statement.setInt(3, book.getStock() );

        int rowsInserted = statement.executeUpdate();
        return  rowsInserted;
    }

    public int update(Book book) throws SQLException, ClassNotFoundException {

        Connection conn = db.connect();

        String sql = "UPDATE Books set name=?, author=?, stock=? WHERE id=?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, book.getName());
        statement.setString(2, book.getAuthor());
        statement.setInt(3, book.getStock());
        statement.setInt(4, book.getId());

        int rowsUpdated = statement.executeUpdate();
        return rowsUpdated;
    }

    public int delete(int id) throws SQLException, ClassNotFoundException {

        int stock = findOne(id).getStock();

        if(stock == 0) {
            Connection conn = db.connect();

            String sql = "DELETE FROM Books WHERE id=?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted;
        }
        return 0;
    }

    public List<Book> show () throws SQLException, ClassNotFoundException {

        Connection conn = db.connect();

        String sql = "SELECT * FROM Books";

        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

        List<Book> Books = new LinkedList<>();

        while (result.next()){

            int id = result.getInt("id");
            String name = result.getString("name");
            String author = result.getString("author");
            int stock  = result.getInt("stock");

            Book book = new Book();

            book.setId(id);
            book.setName(name);
            book.setAuthor(author);
            book.setStock(stock);
            Books.add(book);
        }

        return Books;
    }

    public Book findOne(int id) throws SQLException, ClassNotFoundException {

        Connection conn = db.connect();

        String sql = "SELECT * FROM Books WHERE id=?";


        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet result = statement.executeQuery();

        Book book = new Book();

        while (result.next()){

            int bookid = result.getInt("id");
            String name = result.getString("name");
            String author = result.getString("author");
            int stock  = result.getInt("stock");

            book.setId(bookid);
            book.setName(name);
            book.setAuthor(author);
            book.setStock(stock);
        }

        return book;
    }

}
