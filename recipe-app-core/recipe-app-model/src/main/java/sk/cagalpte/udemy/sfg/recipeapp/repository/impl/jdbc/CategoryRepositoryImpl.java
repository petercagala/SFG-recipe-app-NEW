package sk.cagalpte.udemy.sfg.recipeapp.repository.impl.jdbc;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Category;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.repository.CategoryRepository;

import java.util.List;

@Profile("jdbc")
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public List<Category> findAllByRecipe(Recipe recipe) {
        return null;
    }

    @Override
    public Category findByDescription(String description) {
        return null;
    }

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public void delete(Category category) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
