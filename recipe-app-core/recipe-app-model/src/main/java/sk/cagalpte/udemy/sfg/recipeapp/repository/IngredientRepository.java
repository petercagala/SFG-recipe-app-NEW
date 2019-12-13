package sk.cagalpte.udemy.sfg.recipeapp.repository;

import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Ingredient;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.repository.map.MapRepository;

import java.util.List;

@Repository
public interface IngredientRepository extends MapRepository<Ingredient, Long> {
    public List<Ingredient> findAllByRecipe(Recipe recipe);
}
