package sk.cagalpte.udemy.sfg.recipeapp.services.impl;

import org.springframework.stereotype.Service;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.repository.RecipeRepository;
import sk.cagalpte.udemy.sfg.recipeapp.services.RecipeService;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> findAll() {
        return this.recipeRepository.findAll();
    }

    @Override
    public Recipe findById(Long id) {
        return this.recipeRepository.findById(id);
    }

    @Override
    public Recipe save(Recipe recipe) {
        return this.recipeRepository.save(recipe);
    }

    @Override
    public void delete(Recipe recipe) {
        this.recipeRepository.delete(recipe);
    }

    @Override
    public void deleteById(Long id) {
        this.recipeRepository.deleteById(id);
    }
}
