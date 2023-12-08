package toniazzo.project.store.service;

import org.springframework.stereotype.Service;
import toniazzo.project.store.entity.Category;
import toniazzo.project.store.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

}