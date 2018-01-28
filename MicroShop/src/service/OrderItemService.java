package service;

import java.util.List;

import entity.OrderItem;

public interface OrderItemService {

	public int deleteOrderItem(int id);

	public int insertOrderItem(OrderItem orderItem);

	public OrderItem selectOrderItemById(OrderItem orderItem);

	public List<OrderItem> selectAllOrderItem();

	public int updateOrderNum(int id);

}
