package com.packt.webstore.controller;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
//@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @RequestMapping("/products")
    public String list(Model model) {
        model.addAttribute("products", productService.getAllProducts());

        return "products";
    }

    @RequestMapping("/update/stock")
    public String updateStock(Model model) {
        productService.updateAllStock();

        return "redirect:/products";
    }
}
