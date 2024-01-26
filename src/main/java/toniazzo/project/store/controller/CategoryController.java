package toniazzo.project.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import toniazzo.project.store.service.CategoryService;

@Controller
@RequestMapping("category")
public class CategoryController {


    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void saveCategory() {
        //TODO SAVE METHOD TO CATEGORY
    }
}
