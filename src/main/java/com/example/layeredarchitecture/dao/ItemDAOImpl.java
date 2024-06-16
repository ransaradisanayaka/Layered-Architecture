package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl {
    public ArrayList<ItemDTO> loadAllItem() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Item");
        ArrayList<ItemDTO> itemDTOS = new ArrayList<>();
        while (rst.next()) {
            ItemDTO itemDTO = new ItemDTO(
                    rst.getString("code"),
                    rst.getString("description"),
                    rst.getBigDecimal("unitPrice"),
                    rst.getInt("qtyOnHand"));

            itemDTOS.add(itemDTO);
        }

        return itemDTOS;
    }

    public String generateNewid() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = connection.createStatement().executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

public void saveItem(String code, String description, int qtyOnHand, BigDecimal unitPrice) throws SQLException, ClassNotFoundException {
    Connection connection = DBConnection.getDbConnection().getConnection();
    PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item (code, description, qtyOnHand, unitPrice) VALUES (?,?,?,?)");
    pstm.setString(1, code);
    pstm.setString(2, description);
    pstm.setInt(3,qtyOnHand);
    pstm.setBigDecimal(4,unitPrice);
    pstm.executeUpdate();
}

public Boolean updateItem(String description, BigDecimal unitPrice, int qtyOnHand, String code ) throws SQLException, ClassNotFoundException {
    Connection connection = DBConnection.getDbConnection().getConnection();
    PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
    pstm.setString(1, description);
       pstm.setBigDecimal(2, unitPrice);
    pstm.setInt(3, qtyOnHand);
    pstm.setString(4, code);
    pstm.executeUpdate();

    return null;
}
public boolean exitItem(String code) throws SQLException, ClassNotFoundException {
    Connection connection = DBConnection.getDbConnection().getConnection();
    PreparedStatement pstm = connection.prepareStatement("SELECT code FROM Item WHERE code=?");
    pstm.setString(1, code);
    return pstm.executeQuery().next();
}
public void deleteItem(String code) throws SQLException, ClassNotFoundException {
    Connection connection = DBConnection.getDbConnection().getConnection();
    PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");
    pstm.setString(1, code);
    pstm.executeUpdate();
}
    public ItemDTO findItem(String code) throws SQLException, ClassNotFoundException {
           Connection connection = DBConnection.getDbConnection().getConnection();
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
            pstm.setString(1, code);
            ResultSet rst = pstm.executeQuery();
            rst.next();
            return new ItemDTO(code, rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
    }
}

