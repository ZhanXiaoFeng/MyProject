package dao;

import java.util.List;

import entity.OrderItem;

public interface OrderItemMapper {

	public int deleteOrderItem(int id);

	public int insertOrderItem(OrderItem orderItem);

	public OrderItem selectOrderItemById(OrderItem orderItem);

	public List<OrderItem> selectAllOrderItem();

	public int updateOrderNum(int id);

}