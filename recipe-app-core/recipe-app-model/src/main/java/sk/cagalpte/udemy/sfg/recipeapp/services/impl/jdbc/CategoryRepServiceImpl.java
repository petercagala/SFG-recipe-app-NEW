package sk.cagalpte.udemy.sfg.recipeapp.services.impl.jdbc;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Category;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.services.CategoryRepService;

import java.util.List;

@Profile("jdbc")
@Service
public class CategoryRepServiceImpl implements CategoryRepService {
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
