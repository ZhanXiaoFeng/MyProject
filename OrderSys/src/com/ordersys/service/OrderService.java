package com.ordersys.service;

import java.sql.SQLException;
import java.util.List;

import com.ordersys.bean.Order;

public interface OrderService {
  int addOrder(List<Order> order)throws SQLException;
  
  List<Order> selectOrderByDeskId(int deskId)throws SQLException;
  
  int deleteOrderByDeskId(int deskId)throws SQLException;

}
