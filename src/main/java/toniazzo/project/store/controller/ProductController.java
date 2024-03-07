package toniazzo.project.store.controller;

import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;
import toniazzo.project.store.entity.Product;
import toniazzo.project.store.service.ProductService;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    @Transactional
    List<Product> saveProduct(@RequestBody Product product, Long productId){
        return productService.saveProduct(product, productId);
    }

    @PutMapping
    List<Product> updateProduct(@RequestBody Product product, Long productId){
        return productService.updateProduct(product, productId);
    }

    @DeleteMapping("{id}")
    List<Product> deleteProduct(@PathVariable("id") Long id){
        return productService.deleteProduct(id);
    }

}