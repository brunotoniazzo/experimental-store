package toniazzo.project.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import toniazzo.project.store.entity.Category;
import toniazzo.project.store.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        Sort sort = Sort.by(
                Sort.Order.by("description").ignoreCase(),
                Sort.Order.asc("description").ignoreCase());
        return categoryRepository.findAll(sort);
    }

    public Page<Category> getAllCategoriesByPage(@PageableDefault(sort = "description", size = 10) Pageable pageable) {
        return categoryRepository.findAll(pageable).map(category -> new Category());
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
