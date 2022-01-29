package com.iims.dao.Implement;

import com.iims.dao.SoldBookDao;
import com.iims.database.ConnectionFactory;
import com.iims.model.SoldBook;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SoldBookDaoImpl implements SoldBookDao {

    ConnectionFactory db = new ConnectionFactory();

    public int save(SoldBook soldBook) throws SQLException, ClassNotFoundException {

        Connection conn = db.connect();

        String sql = "INSERT INTO SoldBook (book_id, customer_id) VALUES (?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, soldBook.getBook_id());
        statement.setInt(2, soldBook.getCustomer_id());

        int rowsInserted = statement.executeUpdate();
        return  rowsInserted;
    }

    public List<SoldBook> show () throws SQLException, ClassNotFoundException {

        Connection conn = db.connect();

        String sql ="SELECT * FROM SoldBook";

        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

        List<SoldBook> soldBooks = new LinkedList<>();

        while (result.next()){

            int book_id = result.getInt("book_id");
            int customer_id = result.getInt("customer_id");

            SoldBook soldBook = new SoldBook();

            soldBook.setBook_id(book_id);
            soldBook.setCustomer_id(customer_id);
            soldBooks.add(soldBook);

        }
        return soldBooks;
    }

}
