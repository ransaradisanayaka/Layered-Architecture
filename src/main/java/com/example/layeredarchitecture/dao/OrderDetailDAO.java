package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDAO {
    public boolean saveOrderDetails(String orderId, List<OrderDetailDTO> orderDetailDTOS ) throws SQLException, ClassNotFoundException;

}
