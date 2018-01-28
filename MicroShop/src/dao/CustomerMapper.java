package dao;

import java.util.List;

import entity.Customer;

public interface CustomerMapper {

	public int deleteCustById(int id);

	public int insertCust(Customer customer);

	public List<Customer> selectAllCust();

	public Customer selectCustById(int id);

	public Customer selectByNameAndPwd(Customer customer);

	public int updateByCondition(Customer customer);

}