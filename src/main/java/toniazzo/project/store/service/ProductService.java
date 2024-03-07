package toniazzo.project.store.service;

import jakarta.transaction.Transactional;
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
        Sort sort = Sort.by("id".toUpperCase()).descending().and(
                Sort.by("id".toUpperCase()).ascending());
        return productRepository.findAll(sort);
    }

    public List<Product> saveProduct(Product product, Long productId) {
        if (productRepository.existsById(productId)) {
            throw new IllegalStateException("Product with id " + productId + " already exists.");
        }
        productRepository.save(product);
        return getAllProducts();
    }

    @Transactional
    public List<Product> updateProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalStateException(
                "The Product with id" + productId + "already exists."));
        return getAllProducts();
    }

    public void deleteProduct(Long productId) {
        boolean productExist = productRepository.existsById(productId);

        if (!productExist) {
            throw new IllegalStateException("The product with"+ productId + " doesn't exists");
        }

        productRepository.deleteById(productId);
    }

}
