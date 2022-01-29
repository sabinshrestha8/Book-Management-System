package com.iims.dao;

import com.iims.model.SoldBook;

import java.sql.SQLException;
import java.util.List;

public interface SoldBookDao {

    int save(SoldBook soldBook) throws SQLException, ClassNotFoundException;

    List<SoldBook> show () throws SQLException, ClassNotFoundException;

}
