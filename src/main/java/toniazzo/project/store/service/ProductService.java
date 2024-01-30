package toniazzo.project.store.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import toniazzo.project.store.entity.Product;
import toniazzo.project.store.repository.ProductRepository;
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

    public void saveProduct(Product product, Long productId) {
        if (productRepository.existsById(productId)) {
            throw new IllegalStateException("Product with id " + productId + " already exists.");
        }
        productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        boolean productExist = productRepository.existsById(productId);

        if (!productExist) {
            throw new IllegalStateException("The product with"+ productId + " doesn't exists");
        }

        productRepository.deleteById(productId);
    }

    @Transactional
    public void updateProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalStateException("The Product with id" + productId + "already exists."));
    }

}
