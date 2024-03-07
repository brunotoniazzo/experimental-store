package toniazzo.project.store.controller;

import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import toniazzo.project.store.entity.Category;
import toniazzo.project.store.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping
    @Transactional
    List<Category> saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    List<Category> updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("{id}")
    List<Category> deleteCategory(@PathVariable("id") Long id) {
        return categoryService.deleteCategory(id);
    }

}
