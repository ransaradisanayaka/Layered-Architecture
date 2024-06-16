package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.ItemDTO;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO  {
    public ArrayList<ItemDTO> loadAllItem() throws SQLException, ClassNotFoundException;
    public void saveItem(String code, String description, int qtyOnHand, BigDecimal unitPrice) throws SQLException, ClassNotFoundException;
    public void deleteItem(String code) throws SQLException, ClassNotFoundException;
    public boolean exitItem(String code) throws SQLException, ClassNotFoundException;
    public Boolean updateItem(String description, BigDecimal unitPrice, int qtyOnHand, String code ) throws SQLException, ClassNotFoundException;

    public ItemDTO findItem(String code) throws SQLException, ClassNotFoundException;
    public String generateNewid() throws SQLException, ClassNotFoundException;
    }
