package com.iims.dao.Implement;

import com.iims.dao.CustomerDao;
import com.iims.database.ConnectionFactory;
import com.iims.model.Customer;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CustDaoImpl implements CustomerDao {

    ConnectionFactory db = new ConnectionFactory();

    public int save(Customer customer) throws SQLException, ClassNotFoundException {

        Connection conn = db.connect();

        String sql = "INSERT INTO Customer (name, contact) VALUES (?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, customer.getName());
        statement.setLong(2, customer.getContact());

        int rowsInserted = statement.executeUpdate();
        return  rowsInserted;
    }

    public int update(Customer customer) throws SQLException, ClassNotFoundException {

        Connection conn = db.connect();

        String sql = "UPDATE Customer set name=?, contact=? WHERE id=?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, customer.getName());
        statement.setLong(2, customer.getContact());
        statement.setInt(3, customer.getId());

        int rowsUpdated = statement.executeUpdate();
        return rowsUpdated;
    }

    public int delete(int id) throws SQLException, ClassNotFoundException {

        Connection conn = db.connect();

        String sql = "DELETE FROM Customer WHERE id=?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);

        int rowsDeleted = statement.executeUpdate();
        return rowsDeleted;
    }

    public List<Customer> show () throws SQLException, ClassNotFoundException {

        Connection conn = db.connect();

        String sql = "SELECT * FROM Customer";

        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

        List<Customer> Customers = new LinkedList<>();

        while (result.next()){

            int id = result.getInt("id");
            String name = result.getString("name");
            long contact  = result.getLong("contact");

            Customer customer = new Customer();

            customer.setId(id);
            customer.setName(name);
            customer.setContact(contact);
            Customers.add(customer);
        }

        return Customers;
    }

    public Customer findOne(int id) throws SQLException, ClassNotFoundException {

        Connection conn = db.connect();

        String sql = "SELECT * FROM Customer WHERE id=?";


        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet result = statement.executeQuery();

        Customer customer = new Customer();

        while (result.next()){

            int custId = result.getInt("id");
            String name = result.getString("name");
            long contact  = result.getLong("contact");

            customer.setId(custId);
            customer.setName(name);
            customer.setContact(contact);
        }

        return customer;
    }

}
