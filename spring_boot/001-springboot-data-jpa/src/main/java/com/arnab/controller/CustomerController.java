package com.arnab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arnab.entity.Customer;
import com.arnab.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/save")
	public Customer saveUser(@RequestBody Customer user) {
		return customerService.saveCustomer(user);
	}
	
	@GetMapping("/fetchAll")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/fetchById/{customerId}")
	public Customer getCustomerById(@PathVariable Long customerId){
		return customerService.getCustomerById(customerId);
	}
	
	@GetMapping("/fetchByFirstName/{firstName}")
	public List<Customer> getCustomerByFirstName(@PathVariable String firstName) {
		return customerService.getCustomerByFirstName(firstName);
	}
	
	@GetMapping("/fetchByFirstNameContains/{firstName}")
	public List<Customer> getCustomerByFirstNameContains(@PathVariable String firstName) {
		return customerService.getCustomerByFirstNameContains(firstName);
	}
	
	@GetMapping("/fetchByFirstNameContainsOrderByFirstName/{firstName}")
	public List<Customer> getCustomerByFirstNameContainsOrderByFirstName(@PathVariable String firstName) {
		return customerService.getCustomerByFirstNameContainsOrderByFirstName(firstName);
	}
	
	@GetMapping("/fetchByFirstNameContainsOrderByFirstNameDesc/{firstName}")
	public List<Customer> getCustomerByFirstNameContainsOrderByFirstNameDesc(@PathVariable String firstName) {
		return customerService.getCustomerByFirstNameContainsOrderByFirstNameDesc(firstName);
	}
	
	@GetMapping("/fetchByFirstNameAndLastName")
	public List<Customer> getCustomerByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
		return customerService.getCustomerByFirstNameAndLastName(firstName, lastName);
	}
	
	@GetMapping("/fetchByFirstNameOrLastName")
	public List<Customer> getCustomerByFirstNameOrLastName(@RequestParam String firstName, @RequestParam String lastName) {
		return customerService.getCustomerByFirstNameOrLastName(firstName, lastName);
	}
	
	@GetMapping("/fetchByFirstNameContainsOrLastNameContains")
	public List<Customer> getCustomerByFirstNameContainsOrLastNameContains(@RequestParam String firstName, @RequestParam String lastName) {
		return customerService.getCustomerByFirstNameContainsOrLastNameContains(firstName, lastName);
	}
	
	@GetMapping("/fetchByFirstNameIs")
	public List<Customer> getCustomerByFirstNameIs(@RequestParam String firstName) {
		return customerService.getCustomerByFirstNameIs(firstName);
	}
	
	@GetMapping("/fetchByFirstNameEquals")
	public List<Customer> getCustomerByFirstNameEquals(@RequestParam String firstName) {
		return customerService.getCustomerByFirstNameEquals(firstName);
	}
	
	@GetMapping("/fetchByAgeLessThan")
	public List<Customer> getCustomerByAgeLessThan(@RequestParam int age) {
		return customerService.getCustomerByAgeLessThan(age);
	}
	
	@GetMapping("/fetchByAgeGreaterThan")
	public List<Customer> getCustomerByAgeGreaterThan(@RequestParam int age) {
		return customerService.getCustomerByAgeGreaterThan(age);
	}
	
	@GetMapping("/fetchByAgeGreaterThanEqual")
	public List<Customer> getCustomerByAgeGreaterThanEqual(@RequestParam int age) {
		return customerService.getCustomerByAgeGreaterThanEqual(age);
	}
	
//	@GetMapping("/fetchByAgeIsNull")
//	public List<Customer> getCustomerByFirstNameIsNull(@RequestParam String firstName) {
//		return customerService.getCustomerByFirstNameIsNull(firstName);
//	}
	
	@GetMapping("/fetchByFirstNameLike")
	public List<Customer> getCustomerByFirstNameLike(@RequestParam String firstName) {
		return customerService.getCustomerByFirstNameLike(firstName);
	}
	
	@GetMapping("/fetchByFirstNameNotLike")
	public List<Customer> getCustomerByFirstNameNotLike(@RequestParam String firstName) {
		return customerService.getCustomerByFirstNameNotLike(firstName);
	}
	
	@GetMapping("/fetchByFirstNameStartingWith")
	public List<Customer> getCustomerByFirstNameStartingWith(@RequestParam String firstName) {
		return customerService.getCustomerByFirstNameStartingWith(firstName);
	}
	
	@GetMapping("/fetchByFirstNameEndingWith")
	public List<Customer> getCustomerByFirstNameEndingWith(@RequestParam String firstName) {
		return customerService.getCustomerByFirstNameEndingWith(firstName);
	}
	
	@GetMapping("/fetchByFirstNameContaining")
	public List<Customer> getCustomerByFirstNameContaining(@RequestParam String firstName) {
		return customerService.getCustomerByFirstNameContaining(firstName);
	}
	
	@GetMapping("/fetchByAgeOrderByLastNameDesc")
	public List<Customer> getCustomerByAgeOrderByLastNameDesc(@RequestParam int age) {
		return customerService.getCustomerByAgeOrderByLastNameDesc(age);
	}
	
	@GetMapping("/fetchByLastNameNot")
	public List<Customer> getCustomerByLastNameNot(@RequestParam String lastName) {
		return customerService.getCustomerByLastNameNot(lastName);
	}
	
	@GetMapping("/fetchByAgeIn")
	public List<Customer> getCustomerByAgeIn(@RequestParam List<Integer> age) {
		return customerService.getCustomerByAgeIn(age);
	}
	
	@GetMapping("/fetchByAgeNotIn")
	public List<Customer> getCustomerByAgeNotIn(@RequestParam List<Integer> age) {
		return customerService.getCustomerByAgeNotIn(age);
	}
	
	@GetMapping("/fetchByFirstNameIgnoreCase")
	public List<Customer> getCustomerByFirstNameIgnoreCase(@RequestParam String firstName) {
		return customerService.getCustomerByFirstNameIgnoreCase(firstName);
	}
	
	@GetMapping("/fetchByAgeBetween")
	public List<Customer> getCustomerByAgeBetween(@RequestParam int startAge, @RequestParam int endAge) {
		return customerService.getCustomerByAgeBetween(startAge, endAge);
	}
	
	@GetMapping("/fetchByAgeAfter")
	public List<Customer> getCustomerByAgeAfter(@RequestParam int age) {
		return customerService.getCustomerByAgeAfter(age);
	}
	
	@GetMapping("/fetchByAgeBefore")
	public List<Customer> getCustomerByAgeBefore(@RequestParam int age) {
		return customerService.getCustomerByAgeBefore(age);
	}
	
	@GetMapping("/sortByParametersUsingPagination")
	public Page<Customer> getCustomerSortUsingPagination(@RequestParam int page, @RequestParam int size, @RequestParam String sortFieldName, @RequestParam String sortingOrder) {
		return customerService.getCustomerBySortAndPagination(page, size, sortFieldName, sortingOrder);
	}
	
	@GetMapping("/fetchByFirstNameAndLastNameUsingHQL")
	public List<Customer> getCustomerByFirstNameAndLastNameUsingHQL(@RequestParam String firstName, @RequestParam String lastName) {
		return customerService.getCustomerByFnameAndLnameUsingHQL(firstName, lastName);
	}
	
	@PutMapping("/update/{id}")
	public Customer updateCustomer(@RequestParam Long custId, @RequestBody Customer customer) {
		return customerService.updateCustomer(custId, customer);
	}
	
	@DeleteMapping("/delete/{customerId}")
	public String deleteCustomerById(@PathVariable Long  customerId) {
		return customerService.deleteCustomerById(customerId);
	}
	
	
}
