package toniazzo.project.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import toniazzo.project.store.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}