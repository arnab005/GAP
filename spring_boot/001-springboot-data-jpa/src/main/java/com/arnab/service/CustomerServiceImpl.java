package com.arnab.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.arnab.entity.Customer;
import com.arnab.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(Long userId) {
		Optional<Customer> opUser = customerRepository.findById(userId);
		if(opUser.isPresent()) {
			return opUser.get();
		}
		return null;
	}

	@Override
	public String deleteCustomerById(Long customerId) {
		customerRepository.deleteById(customerId);
		return "success";
	}

	@Override
	public Customer updateCustomer(Long customerId, Customer customer) {
		Customer existingCustomer = customerRepository.findById(customerId).get();
		existingCustomer.setAge(customer.getAge());
		existingCustomer.setFirstName(customer.getFirstName());
		existingCustomer.setLastName(customer.getLastName());
		return customerRepository.save(existingCustomer);
	}

	@Override
	public List<Customer> getCustomerByFirstName(String customerName) {
		return customerRepository.findByFirstName(customerName);
	}

	@Override
	public List<Customer> getCustomerByFirstNameContains(String firstName) {
		return customerRepository.findByFirstNameContains(firstName);
	}

	@Override
	public List<Customer> getCustomerByFirstNameContainsOrderByFirstName(String firstName) {
		return customerRepository.findByFirstNameContainsOrderByFirstName(firstName);
	}

	@Override
	public List<Customer> getCustomerByFirstNameContainsOrderByFirstNameDesc(String firstName) {
		return customerRepository.findByFirstNameContainsOrderByFirstNameDesc(firstName);
	}

	@Override
	public List<Customer> getCustomerByFirstNameAndLastName(String firstName, String lastName) {
		return customerRepository.findByFirstNameAndLastName(firstName,lastName);
	}

	@Override
	public List<Customer> getCustomerByFnameAndLnameUsingHQL(String firstName, String lastName) {
		return customerRepository.findByFnameAndLnameUsingHQL(firstName, lastName);
	}

	@Override
	public List<Customer> getCustomerByFirstNameOrLastName(String firstName, String lastName) {
		return customerRepository.findByFirstNameOrLastName(firstName, lastName);
	}

	@Override
	public List<Customer> getCustomerByFirstNameContainsOrLastNameContains(String firstName, String lastName) {
		return customerRepository.findByFirstNameContainsOrLastNameContains(firstName, lastName);
	}

	@Override
	public List<Customer> getCustomerByFirstNameIs(String firstName) {
		return customerRepository.findByFirstNameIs(firstName);
	}

	@Override
	public List<Customer> getCustomerByFirstNameEquals(String firstName) {
		return customerRepository.findByFirstNameEquals(firstName);
	}

	@Override
	public List<Customer> getCustomerByAgeLessThan(int age) {
		return customerRepository.findByAgeLessThan(age);
	}

	@Override
	public List<Customer> getCustomerByAgeGreaterThan(int age) {
		return customerRepository.findByAgeGreaterThan(age);
	}

	@Override
	public List<Customer> getCustomerByAgeGreaterThanEqual(int age) {
		return customerRepository.findByAgeGreaterThanEqual(age);
	}

	@Override
	public List<Customer> getCustomerByFirstNameLike(String firstName) {
		return customerRepository.findByFirstNameLike(firstName);
	}

	@Override
	public List<Customer> getCustomerByFirstNameNotLike(String firstName) {
		return customerRepository.findByFirstNameNotLike(firstName);
	}

	@Override
	public List<Customer> getCustomerByFirstNameStartingWith(String firstName) {
		return customerRepository.findByFirstNameStartingWith(firstName);
	}

	@Override
	public List<Customer> getCustomerByFirstNameEndingWith(String firstName) {
		return customerRepository.findByFirstNameEndingWith(firstName);
	}

	@Override
	public List<Customer> getCustomerByFirstNameContaining(String firstName) {
		return customerRepository.findByFirstNameContaining(firstName);
	}

	@Override
	public List<Customer> getCustomerByAgeOrderByLastNameDesc(int age) {
		return customerRepository.findByAgeOrderByLastNameDesc(age);
	}

	@Override
	public List<Customer> getCustomerByLastNameNot(String lastName) {
		return customerRepository.findByLastNameNot(lastName);
	}

	@Override
	public List<Customer> getCustomerByAgeIn(List<Integer> age) {
		return customerRepository.findByAgeIn(age);
	}

	@Override
	public List<Customer> getCustomerByAgeNotIn(List<Integer> age) {
		return customerRepository.findByAgeNotIn(age);
	}

	@Override
	public List<Customer> getCustomerByFirstNameIgnoreCase(String firstName) {
		return customerRepository.findByFirstNameIgnoreCase(firstName);
	}

	@Override
	public List<Customer> getCustomerByAgeBetween(int startAge, int endAge) {
		return customerRepository.findByAgeBetween(startAge, endAge);
	}

	@Override
	public List<Customer> getCustomerByAgeAfter(int age) {
		return customerRepository.findByAgeAfter(age);
	}

	@Override
	public List<Customer> getCustomerByAgeBefore(int age) {
		return customerRepository.findByAgeBefore(age);
	}

	@Override
	public Page<Customer> getCustomerBySortAndPagination(int page, int size, String sortBy, String direction) {
		Sort sort = sortBy.equalsIgnoreCase("ASC") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(page, size, sort);
		return customerRepository.findAll(pageable);
	}

//	@Override
//	public List<Customer> getCustomerByFirstNameIsNull(String firstName) {
//		return customerRepository.findByFirstNameIsNull(firstName);
//	}

}
