package sk.cagalpte.udemy.sfg.recipeapp.services;

import org.springframework.stereotype.Service;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Category;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.services.map.MapRepository;

import java.util.List;

@Service
public interface CategoryRepService extends MapRepository<Category, Long> {

    public Category findByDescription(String description);

    public List<Category> findAllByRecipe(Recipe recipe);
}
