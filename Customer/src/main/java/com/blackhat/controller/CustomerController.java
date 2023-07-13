package com.blackhat.controller;

import com.blackhat.model.Customer;
import com.blackhat.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("api/v1/customers")
    public List<Customer> getRecords(){
        return customerService.getRecords();
    }

    @GetMapping("api/v1/customers/{id}")
    public Customer getRecordById(@PathVariable("id") Long id){
        return customerService.getRecordById(id);
    }

    @PostMapping("api/v1/customers")
    public Customer postRecord(@RequestBody Customer customer){
        return customerService.postRecord(customer);
    }

    @PutMapping("api/v1/customers/{id}")
    public Customer putCustomer(@RequestBody Customer customer, @PathVariable("id") Long id){
        return customerService.putCustomer(id, customer);
    }

    @DeleteMapping("api/v1/customers/{id}")
    public void deleteCustomer(@PathVariable("id") Long id){
        customerService.deleteCustomer(id);
    }
}
