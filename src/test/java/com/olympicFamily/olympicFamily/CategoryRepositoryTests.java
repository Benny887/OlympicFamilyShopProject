package com.olympicFamily.olympicFamily;

import com.olympicFamily.olympicFamily.Common.Entity.Category;
import com.olympicFamily.olympicFamily.FrontEnd.category.FECategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoryRepositoryTests {

    @Autowired
    private FECategoryRepository repo;

    @Test
    public void testListEnabledCategories() {
        List<Category> categories = repo.findAllEnabled();
        categories.forEach(category -> {
            System.out.println(category.getName() + " (" + category.isEnabled() + ")");
        });
    }
}
