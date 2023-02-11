package com.olympicFamily.olympicFamily.FrontEnd;

import com.olympicFamily.olympicFamily.Common.Entity.Category;
import com.olympicFamily.olympicFamily.FrontEnd.category.FECategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainFEController {

    @Autowired
    private FECategoryService categoryService;

    @GetMapping("/FEOFAdmin")
    public String viewHomePage(Model model) {
        List<Category> listCategories = categoryService.listNoChildrenCategories();
        model.addAttribute("listCategories", listCategories);

        return "FrontEnd/FEindex";
    }
}
