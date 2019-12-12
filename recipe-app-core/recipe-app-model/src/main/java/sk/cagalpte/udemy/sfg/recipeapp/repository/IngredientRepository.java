package sk.cagalpte.udemy.sfg.recipeapp.repository;

import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Ingredient;
import sk.cagalpte.udemy.sfg.recipeapp.repository.map.MapRepository;

@Repository
public interface IngredientRepository extends MapRepository<Ingredient, Long> {
}
