package com.olympicFamily.olympicFamily.BackEnd.Admin.Category;

import com.olympicFamily.olympicFamily.Common.Entity.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {

    @Query("SELECT c FROM Category c WHERE c.parent.id is NULL")
    List<Category> findRootCategories();

    Category findByName(String name);

    Category findByAlias(String alias);

}
