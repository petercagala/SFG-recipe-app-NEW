package sk.cagalpte.udemy.sfg.recipeapp.repository.impl.hibernate.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.dto.RecipeDTO;
import sk.cagalpte.udemy.sfg.recipeapp.mappers.dto.RecipeDtoMapper;
import sk.cagalpte.udemy.sfg.recipeapp.repository.RecipeRepository;
import sk.cagalpte.udemy.sfg.recipeapp.repository.impl.hibernate.RecipeRepositoryHibernate;

import java.util.List;
import java.util.stream.Collectors;

@Profile("hibernate")
@Repository
public class RecipeRepositoryImpl implements RecipeRepository {

    private final RecipeRepositoryHibernate recipeRepositoryHibernate;

    private final RecipeDtoMapper recipeDtoMapper;

    public RecipeRepositoryImpl(RecipeRepositoryHibernate recipeRepositoryHibernate, RecipeDtoMapper recipeDtoMapper) {
        this.recipeRepositoryHibernate = recipeRepositoryHibernate;
        this.recipeDtoMapper = recipeDtoMapper;
    }


    @Override
    public List<Recipe> findAll() {
        List<Recipe> recipes = this.recipeRepositoryHibernate.findAll().stream()
                .map(recipeDTO -> {
                    return this.recipeDtoMapper.recipeDtoToRecipe(recipeDTO);
                }).collect(Collectors.toList());
        return recipes;
    }

    @Override
    public Recipe findById(Long id) {
        return this.recipeDtoMapper.recipeDtoToRecipe(this.recipeRepositoryHibernate.findById(id).orElse(null));
    }

    @Override
    public Recipe save(Recipe recipe) {
        RecipeDTO recipeDTO = new RecipeDTO().createBuilder()
                .description(recipe.getDescription())
                .prepTime(recipe.getPrepTime())
                .cookTime(recipe.getCookTime())
                .servings(recipe.getServings())
                .source(recipe.getSource())
                .url(recipe.getUrl())
                .directions(recipe.getDirections())
                .images(recipe.getImages())
                .difficulty(recipe.getDifficulty())
                .build();
        RecipeDTO recipeDtoSaved = this.recipeRepositoryHibernate.save(recipeDTO);
        return this.recipeDtoMapper.recipeDtoToRecipe(recipeDtoSaved);
    }

    @Override
    public void delete(Recipe recipe) {
        this.recipeRepositoryHibernate.delete(this.recipeDtoMapper.recipeToRecipeDTO(recipe));
    }

    @Override
    public void deleteById(Long id) {
        this.recipeRepositoryHibernate.deleteById(id);
    }
}
