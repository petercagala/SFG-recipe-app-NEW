package sk.cagalpte.udemy.sfg.recipeapp.repository.impl.jdbc;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Ingredient;
import sk.cagalpte.udemy.sfg.recipeapp.repository.IngredientRepository;

import java.util.List;

@Profile("jdbc")
@Repository
public class IngredientRepositoryImpl implements IngredientRepository {

    @Override
    public List<Ingredient> findAll() {
        return null;
    }

    @Override
    public Ingredient findById(Long id) {
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
