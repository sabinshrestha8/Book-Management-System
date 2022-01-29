package com.iims.dao;

import com.iims.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {

    int save(Customer customer) throws SQLException, ClassNotFoundException;

    int update(Customer customer) throws SQLException, ClassNotFoundException;

    int delete(int id) throws SQLException, ClassNotFoundException;

    List<Customer> show () throws SQLException, ClassNotFoundException;

    Customer findOne(int id) throws SQLException, ClassNotFoundException;

}
