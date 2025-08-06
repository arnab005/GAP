package com.arnab.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import com.arnab.entity.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomerById(Long customerId);

	String deleteCustomerById(Long customerId);

	Customer updateCustomer(Long customerId, Customer customer);

	List<Customer> getCustomerByFirstName(String firstName);

	List<Customer> getCustomerByFirstNameContains(String firstName);

	List<Customer> getCustomerByFirstNameContainsOrderByFirstName(String firstName);

	List<Customer> getCustomerByFirstNameContainsOrderByFirstNameDesc(String firstName);

	List<Customer> getCustomerByFirstNameAndLastName(String firstName, String lastName);
	
	List<Customer> getCustomerByFnameAndLnameUsingHQL(String firstName, String lastName);

	List<Customer> getCustomerByFirstNameOrLastName(String firstName, String lastName);

	List<Customer> getCustomerByFirstNameContainsOrLastNameContains(String firstName, String lastName);

	List<Customer> getCustomerByFirstNameIs(String firstName);

	List<Customer> getCustomerByFirstNameEquals(String firstName);

	List<Customer> getCustomerByAgeLessThan(int age);

	List<Customer> getCustomerByAgeGreaterThan(int age);

	List<Customer> getCustomerByAgeGreaterThanEqual(int age);

	List<Customer> getCustomerByFirstNameLike(String firstName);

	List<Customer> getCustomerByFirstNameNotLike(String firstName);

	List<Customer> getCustomerByFirstNameStartingWith(String firstName);

	List<Customer> getCustomerByFirstNameEndingWith(String firstName);

	List<Customer> getCustomerByFirstNameContaining(String firstName);

	List<Customer> getCustomerByAgeOrderByLastNameDesc(int age);

	List<Customer> getCustomerByLastNameNot(String lastName);

	List<Customer> getCustomerByAgeIn(List<Integer> age);

	List<Customer> getCustomerByAgeNotIn(List<Integer> age);

	List<Customer> getCustomerByFirstNameIgnoreCase(String firstName);

	List<Customer> getCustomerByAgeBetween(int startAge, int endAge);

	List<Customer> getCustomerByAgeAfter(int age);

	List<Customer> getCustomerByAgeBefore(int age);

	//List<Customer> getCustomerByFirstNameIsNull(String firstName);

	Page<Customer> getCustomerBySortAndPagination(int page, int size, String sortBy, String direction);

}
