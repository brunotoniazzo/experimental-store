package toniazzo.project.store.service;

import org.springframework.data.domain.Sort;
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
        Sort sort = Sort.by(
                Sort.Order.by("name").ignoreCase(),
                Sort.Order.asc("name").ignoreCase());
        return productRepository.findAll(sort);
    }

    public List<Product> saveProduct(Product product) {
        productRepository.save(product);
        return getAllProducts();
    }

    public List<Product> deleteProduct(Long productId) {
        productRepository.deleteById(productId);
        return getAllProducts();
    }

    public List<Product> updateProduct(Product product) {
        productRepository.save(product);
        return getAllProducts();
    }

}
