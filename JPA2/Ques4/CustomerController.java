package com.springJPA2.JPA2.Ques4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping("/add")
    public Customer create() {
        Customer customer = new Customer();
        customer.setFname("Himanshi");
        customer.setLname("Sharma");
        Address address = new Address();
        address.setCity("Delhi");
        address.setPincode("11012");
        address.setStreetNo("12 Parshuram marg");
        customer.setAddress(address);
        return customerRepository.save(customer);
    }

    @PutMapping("/update")
    public Customer update() {
        Customer customer = customerRepository.findById(102L).orElse(null);
        if (customer == null) return null;
        Address address = customer.getAddress();
        address.setCity("Delhi");
        address.setPincode("110012");
        address.setStreetNo("12 Parshuram marg");
        customer.setAddress(address);
        return customerRepository.save(customer);
    }
}
