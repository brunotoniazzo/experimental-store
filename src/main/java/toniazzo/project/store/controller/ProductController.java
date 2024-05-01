package toniazzo.project.store.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import toniazzo.project.store.entity.Product;
import toniazzo.project.store.service.ProductService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/products/")
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
    List<Product> saveProduct(@RequestBody @Valid Product product){
        return productService.saveProduct(product);
    }

    @PutMapping
    List<Product> updateProduct(@RequestBody @Valid Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("{id}")
    List<Product> deleteProduct(@PathVariable("id") Long id){
        return productService.deleteProduct(id);
    }

}
