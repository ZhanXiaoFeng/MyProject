package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.CustomerMapper;
import entity.Customer;
import service.CustomerService;
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	@Qualifier("customerMapper")
	private CustomerMapper customerMapper;
	
	
	public CustomerMapper getCustomerMapper() {
		return customerMapper;
	}


	public void setCustomerMapper(CustomerMapper customerMapper) {
		this.customerMapper = customerMapper;
	}


	@Override
	public int regist(Customer customer) {
		return customerMapper.insertCust(customer);
	}


	@Override
	public int deleteCustById(int id) {
		return customerMapper.deleteCustById(id);
	}


	@Override
	public Customer selectCustById(int id) {
		return customerMapper.selectCustById(id);
	}


	@Override
	public Customer login(Customer customer) {
		return customerMapper.selectByNameAndPwd(customer);
	}


	@Override
	public int updateByCondition(Customer customer ) {
		return customerMapper.updateByCondition(customer );
	}


	@Override
	public List<Customer> selectAllCust() {
		return customerMapper.selectAllCust();
	}

}
