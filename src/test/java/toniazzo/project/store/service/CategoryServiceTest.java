package toniazzo.project.store.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
class CategoryServiceTest {

    @Test
    @DisplayName("Should get all Categories from Database")
    void getAllCategoriesSuccess() {

    }

    @Test
    void saveCategory() {
    }

    @Test
    void deleteCategory() {
    }

    @Test
    void updateCategory() {
    }
}