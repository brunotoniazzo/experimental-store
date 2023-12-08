package toniazzo.project.store.service;

import org.springframework.stereotype.Service;
import toniazzo.project.store.entity.Product;
import toniazzo.project.store.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
