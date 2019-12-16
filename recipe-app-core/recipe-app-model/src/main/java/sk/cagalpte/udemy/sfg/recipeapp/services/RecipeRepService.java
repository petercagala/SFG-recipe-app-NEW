package sk.cagalpte.udemy.sfg.recipeapp.services;

import org.springframework.stereotype.Service;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.services.map.MapRepository;

@Service
public interface RecipeRepService extends MapRepository<Recipe, Long> {
}
