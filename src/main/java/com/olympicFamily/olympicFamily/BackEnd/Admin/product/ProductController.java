package com.olympicFamily.olympicFamily.BackEnd.Admin.product;

import java.util.List;

import com.olympicFamily.olympicFamily.BackEnd.Admin.brand.BrandService;
import com.olympicFamily.olympicFamily.Common.Entity.Brand;
import com.olympicFamily.olympicFamily.Common.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProductController {
    @Autowired private ProductService productService;
    @Autowired private BrandService brandService;

    @GetMapping("/products")
    public String listAll(Model model) {
        List<Product> listProducts = productService.listAll();

        model.addAttribute("listProducts", listProducts);

        return "products/products";
    }

    @GetMapping("/products/new")
    public String newProduct(Model model) {
        List<Brand> listBrands = brandService.listAll();

        Product product = new Product();
        product.setEnabled(true);
        product.setInStock(true);

        model.addAttribute("product", product);
        model.addAttribute("listBrands", listBrands);
        model.addAttribute("pageTitle", "Create New Product");

        return "products/product_form";
    }

    @PostMapping("/products/save")
    public String saveProduct(Product product) {
        System.out.println("Product Name: " + product.getName());
        System.out.println("Brand ID: " + product.getBrand().getId());
        System.out.println("Category ID: " + product.getCategory().getId());

        return "redirect:/products";
    }
}
