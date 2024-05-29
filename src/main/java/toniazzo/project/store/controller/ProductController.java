package toniazzo.project.store.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.OK)
    List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    List<Product> saveProduct(@RequestBody @Valid Product product){
        return productService.saveProduct(product);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    List<Product> updateProduct(@RequestBody @Valid Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    List<Product> deleteProduct(@PathVariable("id") Long id){
        return productService.deleteProduct(id);
    }

}
