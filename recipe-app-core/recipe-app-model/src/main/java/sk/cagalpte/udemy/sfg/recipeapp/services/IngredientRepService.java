package sk.cagalpte.udemy.sfg.recipeapp.services;

import org.springframework.stereotype.Service;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Ingredient;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.services.map.MapRepository;

import java.util.List;

@Service
public interface IngredientRepService extends MapRepository<Ingredient, Long> {
    public List<Ingredient> findAllByRecipe(Recipe recipe);
}
