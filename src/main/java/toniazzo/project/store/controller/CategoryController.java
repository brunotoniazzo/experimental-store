package toniazzo.project.store.controller;

import jakarta.transaction.Transactional;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import toniazzo.project.store.entity.Category;
import toniazzo.project.store.service.CategoryService;

import java.util.*;

@RestController
@RequestMapping(path = "/api/categories/")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    Page<Category> getAllCategoriesByPage(Pageable pageable) {
//        return categoryService.getAllCategoriesByPage(pageable);
//    }

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public List<Category> saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Category> updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<Category> deleteCategory(@PathVariable("id") Long id) {
        return categoryService.deleteCategory(id);
    }
}