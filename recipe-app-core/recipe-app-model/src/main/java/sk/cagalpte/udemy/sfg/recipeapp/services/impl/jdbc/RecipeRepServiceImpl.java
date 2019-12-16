package sk.cagalpte.udemy.sfg.recipeapp.services.impl.jdbc;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.services.RecipeRepService;

import java.util.List;

@Profile("jdbc")
@Service
public class RecipeRepServiceImpl implements RecipeRepService {
    @Override
    public List<Recipe> findAll() {
        return null;
    }

    @Override
    public Recipe findById(Long id) {
        return null;
    }

    @Override
    public Recipe save(Recipe recipe) {
        return null;
    }

    @Override
    public void delete(Recipe recipe) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
