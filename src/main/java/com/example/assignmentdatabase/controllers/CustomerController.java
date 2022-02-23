package com.example.assignmentdatabase.controllers;
import com.example.assignmentdatabase.data_access.CustomerRepository;
import com.example.assignmentdatabase.data_access.CustomerRepositoryImpl;
import com.example.assignmentdatabase.models.Customer;
import com.example.assignmentdatabase.models.CustomerCountry;
import com.example.assignmentdatabase.models.CustomerGenre;
import com.example.assignmentdatabase.models.CustomerSpender;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class CustomerController {
    private final CustomerRepositoryImpl customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = (CustomerRepositoryImpl) customerRepository;
    }

    @RequestMapping (value = "/api/customer", method = RequestMethod.GET)
    public ArrayList<Customer>selectAllCustomers() {
        return customerRepository.selectAllCustomers();
    }

    //
    @RequestMapping(value = "api/customer/{customerId}", method = RequestMethod.GET)
    public Customer selectSpecificCustomerById(@PathVariable("customerId")  int customerId) {

    return customerRepository.selectSpecificCustomerById(customerId);
    }

    //
    @RequestMapping(value = "api/customer/{firstName}", method = RequestMethod.GET )
    public Customer selectCustomerByName(@PathVariable String firstName){
        return customerRepository.selectCustomerByName(firstName);
    }

    @RequestMapping (value = "api/page/{limit}/{offset}", method = RequestMethod.GET)
    public ArrayList<Customer>selectPageOfCustomers(@PathVariable String limit, @PathVariable String offset) {
        return customerRepository.selectPageOfCustomers(limit, offset);

}//test
    @RequestMapping (value = "api/customer", method = RequestMethod.POST)
    public boolean addCustomer(@RequestBody Customer customer){
        return customerRepository.addCustomer(customer);
    }

    @RequestMapping (value = "api/customer", method = RequestMethod.PUT)
    public boolean updateCustomer(@RequestBody Customer customer){
        return customerRepository.updateCustomer(customer);
    }

    @RequestMapping (value = "/api/customer/country", method = RequestMethod.GET)
    public ArrayList<CustomerCountry>returnCustomerCountry() {
        return customerRepository.returnCustomerCountry();
    }

    @RequestMapping (value = "/api/customer/spender", method = RequestMethod.GET)
    public ArrayList<CustomerSpender>returnCustomerSpender() {

        return customerRepository.returnCustomerSpender();
    }

    @RequestMapping (value = "/api/customer/{customerId}/genre", method = RequestMethod.GET)
    public ArrayList<CustomerGenre> getCustomerGenre(@PathVariable String customerId) {
        return customerRepository.getCustomerGenre();
    }

}
