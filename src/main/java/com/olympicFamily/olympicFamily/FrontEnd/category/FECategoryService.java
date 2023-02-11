package com.olympicFamily.olympicFamily.FrontEnd.category;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.olympicFamily.olympicFamily.Common.Entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FECategoryService {

    @Autowired
    private FECategoryRepository repo;

    public List<Category> listNoChildrenCategories() {
        List<Category> listNoChildrenCategories = new ArrayList<>();

        List<Category> listEnabledCategories = repo.findAllEnabled();

        listEnabledCategories.forEach(category -> {
            Set<Category> children = category.getChildren();
            if (children == null || children.size() == 0) {
                listNoChildrenCategories.add(category);
            }
        });

        return listNoChildrenCategories;
    }
}
