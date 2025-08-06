package com.arnab.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.arnab.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByFirstName(String customerName);

	List<Customer> findByFirstNameContains(String firstName);

	List<Customer> findByFirstNameContainsOrderByFirstName(String firstName);

	List<Customer> findByFirstNameContainsOrderByFirstNameDesc(String firstName);

	List<Customer> findByFirstNameAndLastName(String firstName, String lastName);

	@Query("from Customer where firstName=:firstName and lastName=:lastName")
	List<Customer> findByFnameAndLnameUsingHQL(String firstName, String lastName);

	List<Customer> findByFirstNameOrLastName(String firstName, String lastName);

	List<Customer> findByFirstNameContainsOrLastNameContains(String firstName, String lastName);

	List<Customer> findByFirstNameIs(String firstName);

	List<Customer> findByFirstNameEquals(String firstName);

	List<Customer> findByAgeLessThan(int age);

	List<Customer> findByAgeGreaterThan(int age);

	List<Customer> findByAgeGreaterThanEqual(int age);

	List<Customer> findByFirstNameLike(String firstName);

	List<Customer> findByFirstNameNotLike(String firstName);

	List<Customer> findByFirstNameStartingWith(String firstName);

	List<Customer> findByFirstNameEndingWith(String firstName);

	List<Customer> findByFirstNameContaining(String firstName);

	List<Customer> findByAgeOrderByLastNameDesc(int age);

	List<Customer> findByLastNameNot(String lastName);

	List<Customer> findByAgeIn(List<Integer> age);

	List<Customer> findByAgeNotIn(List<Integer> age);

	List<Customer> findByFirstNameIgnoreCase(String firstName);

	List<Customer> findByAgeBetween(int startAge, int endAge);

	List<Customer> findByAgeAfter(int age);

	List<Customer> findByAgeBefore(int age);

	//List<Customer> findByFirstNameIsNull(String firstName);


}
