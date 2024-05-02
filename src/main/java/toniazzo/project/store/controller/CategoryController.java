package toniazzo.project.store.controller;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import toniazzo.project.store.entity.Category;
import toniazzo.project.store.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/categories/")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping
    Page<Category> getAllCategoriesByPage(Pageable pageable) {
        return categoryService.getAllCategoriesByPage(pageable);
    }

    @PostMapping
    @Transactional
    List<Category> saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @PutMapping
    List<Category> updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("{id}")
    List<Category> deleteCategory(@PathVariable("id") Long id) {
        return categoryService.deleteCategory(id);
    }

}
