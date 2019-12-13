package sk.cagalpte.udemy.sfg.recipeapp.services.impl;

import org.springframework.stereotype.Service;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Ingredient;
import sk.cagalpte.udemy.sfg.recipeapp.repository.IngredientRepository;
import sk.cagalpte.udemy.sfg.recipeapp.services.IngredientService;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> findAll() {
        return this.ingredientRepository.findAll();
    }

    @Override
    public Ingredient findById(Long id) {
        return this.ingredientRepository.findById(id);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return this.ingredientRepository.save(ingredient);
    }

    @Override
    public void delete(Ingredient ingredient) {
        this.ingredientRepository.delete(ingredient);
    }

    @Override
    public void deleteById(Long id) {
        this.ingredientRepository.deleteById(id);
    }
}
