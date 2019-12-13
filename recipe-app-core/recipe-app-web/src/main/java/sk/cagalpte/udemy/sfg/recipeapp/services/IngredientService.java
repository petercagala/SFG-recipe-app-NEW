package sk.cagalpte.udemy.sfg.recipeapp.services;

import org.springframework.stereotype.Service;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Ingredient;
import sk.cagalpte.udemy.sfg.recipeapp.services.map.MapService;

@Service
public interface IngredientService extends MapService<Ingredient, Long> {
}
