package sk.cagalpte.udemy.sfg.recipeapp.repository;

import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Category;
import sk.cagalpte.udemy.sfg.recipeapp.repository.map.MapRepository;

@Repository
public interface CategoryRepository extends MapRepository<Category, Long> {
}
