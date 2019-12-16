package sk.cagalpte.udemy.sfg.recipeapp.services.impl;

import org.springframework.stereotype.Service;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Ingredient;
import sk.cagalpte.udemy.sfg.recipeapp.services.IngredientRepService;
import sk.cagalpte.udemy.sfg.recipeapp.services.IngredientService;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepService ingredientRepService;

    public IngredientServiceImpl(IngredientRepService ingredientRepService) {
        this.ingredientRepService = ingredientRepService;
    }

    @Override
    public List<Ingredient> findAll() {
        return this.ingredientRepService.findAll();
    }

    @Override
    public Ingredient findById(Long id) {
        return this.ingredientRepService.findById(id);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return this.ingredientRepService.save(ingredient);
    }

    @Override
    public void delete(Ingredient ingredient) {
        this.ingredientRepService.delete(ingredient);
    }

    @Override
    public void deleteById(Long id) {
        this.ingredientRepService.deleteById(id);
    }
}
