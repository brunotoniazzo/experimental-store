package toniazzo.project.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import toniazzo.project.store.entity.Category;
import toniazzo.project.store.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        Sort sort = Sort.by("name".toUpperCase()).descending().and(
                Sort.by("name".toUpperCase()).ascending());
        return categoryRepository.findAll(sort);
    }

    public List<Category> saveCategory(Category category) {
        categoryRepository.save(category);
        return getAllCategories();
    }

    public List<Category> deleteCategory (Long categoryId) {
        categoryRepository.deleteById(categoryId);
        return getAllCategories();
    }

    public List<Category> updateCategory (Category category) {
        categoryRepository.save(category);
        return getAllCategories();
    }

}
