package com.olympicFamily.olympicFamily.BackEnd.Admin.product;

import com.olympicFamily.olympicFamily.Common.Entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;



public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

}
