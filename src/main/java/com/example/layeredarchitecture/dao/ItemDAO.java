package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO {
    public ArrayList<ItemDTO> loadAllItem() throws SQLException, ClassNotFoundException;
    public void saveItem(String code, String description, String qtyOnHand, String unitPrice) throws SQLException, ClassNotFoundException;
    public void updateItem(String code, String description, String qtyOnHand, String unitPrice) throws SQLException, ClassNotFoundException;
    public void deleteItem(String code) throws SQLException, ClassNotFoundException;
    public boolean exitItem(String code) throws SQLException, ClassNotFoundException;

    public String addNewItem() throws SQLException, ClassNotFoundException ;
    }
