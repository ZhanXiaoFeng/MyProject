package service;

import java.util.List;

import entity.Customer;

public interface CustomerService {

	public int regist(Customer customer);

	public int deleteCustById(int id);

	public Customer selectCustById(int id);

	public Customer login(Customer customer);
	
	public List<Customer> selectAllCust();

	public int updateByCondition(Customer customer);
}
