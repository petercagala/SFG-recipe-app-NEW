package sk.cagalpte.udemy.sfg.recipeapp.services.impl.jdbc;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Ingredient;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.services.IngredientRepService;

import java.util.List;

@Profile("jdbc")
@Service
public class IngredientRepServiceImpl implements IngredientRepService {

    @Override
    public List<Ingredient> findAll() {
        return null;
    }

    @Override
    public Ingredient findById(Long id) {
        return null;
    }

    @Override
    public List<Ingredient> findAllByRecipe(Recipe recipe) {
        return null;
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return null;
    }

    @Override
    public void delete(Ingredient ingredient) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
