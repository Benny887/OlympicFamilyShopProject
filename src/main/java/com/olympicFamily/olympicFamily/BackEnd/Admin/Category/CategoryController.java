package com.olympicFamily.olympicFamily.BackEnd.Admin.Category;

import java.util.List;

import com.olympicFamily.olympicFamily.Common.Entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping("/categories")
    public String listAll(Model model) {
        List<Category> listCategories = service.listAll();
        model.addAttribute("listCategories", listCategories);

        return "categories/categories";
    }

    @GetMapping("/categories/new")
    public String newCategory(Model model) {
        List<Category> listCategories = service.listCategoriesUsedInForm();

        model.addAttribute("category", new Category());
        model.addAttribute("listCategories", listCategories);
        model.addAttribute("pageTitle", "Create New Category");

        return "categories/category_form";
    }
}