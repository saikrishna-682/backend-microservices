package com.blackhat.service;

import com.blackhat.exception.ResponseIncorrect;
import com.blackhat.exception.ResponseNotFound;
import com.blackhat.model.Customer;
import com.blackhat.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getRecords() {
        return customerRepository.findAll();
    }

    public Customer getRecordById(Long id) {
        return customerRepository.findById(id).orElseThrow(()->new ResponseNotFound("The ID requested is not found : [%s]".formatted(id)));
    }

    public Customer postRecord(Customer customer) {
        if(emailvalidation(customer.getEmail())){
            throw new ResponseIncorrect("Email address already exists, Please try with new Email address");
        }
        return customerRepository.save(customer);
    }

    public boolean emailvalidation(String email){
        return customerRepository.existsByEmail(email);
    }

    public Customer putCustomer(Long id, Customer customer) {
        Optional<Customer> record = customerRepository.findById(id);
        if(record.isPresent()){
            Customer presentCustomer = record.get();
            presentCustomer.setId(customer.getId());
            presentCustomer.setName(customer.getName());
            presentCustomer.setEmail(customer.getEmail());
            presentCustomer.setAge(customer.getAge());

            return customerRepository.save(presentCustomer);
        }else{
            return null;
        }
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
