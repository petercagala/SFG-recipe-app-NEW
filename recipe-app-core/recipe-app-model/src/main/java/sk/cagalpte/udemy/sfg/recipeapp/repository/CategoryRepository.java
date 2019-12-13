package sk.cagalpte.udemy.sfg.recipeapp.repository;

import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Category;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.repository.map.MapRepository;

import java.util.List;

@Repository
public interface CategoryRepository extends MapRepository<Category, Long> {

    public Category findByDescription(String description);

    public List<Category> findAllByRecipe(Recipe recipe);
}
