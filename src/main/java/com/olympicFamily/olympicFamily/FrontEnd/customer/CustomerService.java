package com.olympicFamily.olympicFamily.FrontEnd.customer;

import java.util.List;

import com.olympicFamily.olympicFamily.BackEnd.Admin.setting.country.CountryRepository;
import com.olympicFamily.olympicFamily.Common.Entity.Country;
import com.olympicFamily.olympicFamily.Common.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {

    @Autowired
    private CountryRepository countryRepo;
    @Autowired
    private CustomerRepository customerRepo;

    public List<Country> listAllCountries() {
        return countryRepo.findAllByOrderByNameAsc();
    }

    public boolean isEmailUnique(String email) {
        Customer customer = customerRepo.findByEmail(email);
        return customer == null;
    }
}
