package sk.cagalpte.udemy.sfg.recipeapp.repository.impl.jdbc;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.repository.RecipeRepository;

import java.util.List;

@Profile("jdbc")
@Repository
public class RecipeRepositoryImpl implements RecipeRepository {
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
