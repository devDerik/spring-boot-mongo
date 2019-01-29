package com.example.springbootmongo;

import com.example.springbootmongo.model.Customer;
import com.example.springbootmongo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class ApiController {

  @Autowired
  CustomerRepository customerRepository;

  @GetMapping("/customer")
  public List<Customer> getAll() {
    System.out.println("-------------------------> get api <---------------------------");
    return customerRepository.findAll();
  }

  @PostMapping("/customer/add")
  public void insert() {
    customerRepository.save(new Customer("name" + UUID.randomUUID().toString(), "lastName"));
  }
}
