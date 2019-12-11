package sk.cagalpte.udemy.sfg.recipeapp.repository.impl.hibernate.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.repository.RecipeRepository;
import sk.cagalpte.udemy.sfg.recipeapp.repository.impl.hibernate.RecipeRepositoryHibernate;

import java.util.List;

@Profile("hibernate")
@Repository
public class RecipeRepositoryImpl implements RecipeRepository {

    private final RecipeRepositoryHibernate recipeRepositoryHibernate;

    public RecipeRepositoryImpl(RecipeRepositoryHibernate recipeRepositoryHibernate) {
        this.recipeRepositoryHibernate = recipeRepositoryHibernate;
    }


    @Override
    public List<Recipe> findAll() {
        return null;
    }

    @Override
    public Recipe findById(Long aLong) {
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
    public void deleteById(Long aLong) {

    }
}
