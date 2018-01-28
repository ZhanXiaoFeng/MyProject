package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.OrderMapper;
import entity.Order;
import service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	@Qualifier("orderMapper")
	private OrderMapper orderMapper;

	public OrderMapper getOrderMapper() {
		return orderMapper;
	}

	public void setOrderMapper(OrderMapper orderMapper) {
		this.orderMapper = orderMapper;
	}

	@Override
	public List<Order> selectByPrimaryKey(int orderId) {
		return orderMapper.selectByPrimaryKey(orderId);
	}

	@Override
	public int insertOrder(Order order) {
		return orderMapper.insertOrder(order);
	}

	@Override
	public int updateByPrimaryKeySelective(Order order) {
		return orderMapper.updateByPrimaryKeySelective(order);
	}

	@Override
	public int deleteByPrimaryKey(int id) {
		return orderMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Order selectAllByUserId(int userId) {
		return orderMapper.selectAllByUserId(userId);
	}

	@Override
	public Order selectOrderByStatus(int status) {
		return orderMapper.selectOrderByStatus(status);
	}

	@Override
	public Order selectOrderById(int orderId) {
		return orderMapper.selectOrderById(orderId);
	}

	@Override
	public int updateOrderStatusById(Order order) {
		return orderMapper.updateOrderStatusById(order);
	}

	@Override
	public List<Order> showCartByCustidAndStatus(int orderId) {
		return orderMapper.showCartByCustidAndStatus(orderId);
	}

}
