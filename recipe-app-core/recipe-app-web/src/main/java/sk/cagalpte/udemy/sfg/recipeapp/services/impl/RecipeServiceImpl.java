package sk.cagalpte.udemy.sfg.recipeapp.services.impl;

import org.springframework.stereotype.Service;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.services.RecipeRepService;
import sk.cagalpte.udemy.sfg.recipeapp.services.RecipeService;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepService recipeRepService;

    public RecipeServiceImpl(RecipeRepService recipeRepService) {
        this.recipeRepService = recipeRepService;
    }

    @Override
    public List<Recipe> findAll() {
        return this.recipeRepService.findAll();
    }

    @Override
    public Recipe findById(Long id) {
        return this.recipeRepService.findById(id);
    }

    @Override
    public Recipe save(Recipe recipe) {
        return this.recipeRepService.save(recipe);
    }

    @Override
    public void delete(Recipe recipe) {
        this.recipeRepService.delete(recipe);
    }

    @Override
    public void deleteById(Long id) {
        this.recipeRepService.deleteById(id);
    }
}
