package com.olympicFamily.olympicFamily.FrontEnd.product;

import com.olympicFamily.olympicFamily.Common.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FEProductService {
    public static final int PRODUCTS_PER_PAGE = 10;

    @Autowired
    private FEProductRepository  repo;

    public Page<Product> listByCategory(int pageNum, Integer categoryId) {
        String categoryIdMatch = "-" + String.valueOf(categoryId) + "-";
        Pageable pageable = PageRequest.of(pageNum - 1, PRODUCTS_PER_PAGE);

        return repo.listByCategory(categoryId, categoryIdMatch, pageable);

    }
}
