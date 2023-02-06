package com.olympicFamily.olympicFamily.BackEnd.Admin.product;

import java.util.List;

import com.olympicFamily.olympicFamily.Common.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

    @Autowired private ProductRepository repo;

    public List<Product> listAll() {
        return (List<Product>) repo.findAll();
    }
}
