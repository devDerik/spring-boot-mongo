package com.example.springbootmongo.repository;

import com.example.springbootmongo.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
