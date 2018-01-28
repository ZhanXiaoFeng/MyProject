package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.OrderItemMapper;
import entity.OrderItem;
import service.OrderItemService;

@Service("orderItemService")
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	@Qualifier("orderItemMapper")
	private OrderItemMapper orderItemMapper;

	public OrderItemMapper getOrderItemMapper() {
		return orderItemMapper;
	}

	public void setOrderItemMapper(OrderItemMapper orderItemMapper) {
		this.orderItemMapper = orderItemMapper;
	}

	@Override
	public int deleteOrderItem(int id) {
		return orderItemMapper.deleteOrderItem(id);
	}

	@Override
	public int insertOrderItem(OrderItem orderItem) {
		return orderItemMapper.insertOrderItem(orderItem);
	}

	@Override
	public OrderItem selectOrderItemById(OrderItem orderItem) {
		return orderItemMapper.selectOrderItemById(orderItem);
	}

	@Override
	public List<OrderItem> selectAllOrderItem() {
		return orderItemMapper.selectAllOrderItem();
	}

	@Override
	public int updateOrderNum(int id) {
		return orderItemMapper.updateOrderNum(id);
	}

}
