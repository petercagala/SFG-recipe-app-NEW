package sk.cagalpte.udemy.sfg.recipeapp.repository.impl.hibernate.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.dto.RecipeDTO;
import sk.cagalpte.udemy.sfg.recipeapp.mappers.dto.RecipeDtoMapper;
import sk.cagalpte.udemy.sfg.recipeapp.repository.CategoryRepository;
import sk.cagalpte.udemy.sfg.recipeapp.repository.IngredientRepository;
import sk.cagalpte.udemy.sfg.recipeapp.repository.NotesRepository;
import sk.cagalpte.udemy.sfg.recipeapp.repository.RecipeRepository;
import sk.cagalpte.udemy.sfg.recipeapp.repository.impl.hibernate.RecipeRepositoryHibernate;

import java.util.List;
import java.util.stream.Collectors;

@Profile("hibernate")
@Repository
public class RecipeRepositoryImpl implements RecipeRepository {

    private final RecipeRepositoryHibernate recipeRepositoryHibernate;

    private final RecipeDtoMapper recipeDtoMapper;

    private final NotesRepository notesRepository;

    private final IngredientRepository ingredientRepository;

    private final CategoryRepository categoryRepository;



    public RecipeRepositoryImpl(RecipeRepositoryHibernate recipeRepositoryHibernate, RecipeDtoMapper recipeDtoMapper, NotesRepository notesRepository, IngredientRepository ingredientRepository, CategoryRepository categoryRepository) {
        this.recipeRepositoryHibernate = recipeRepositoryHibernate;
        this.recipeDtoMapper = recipeDtoMapper;
        this.notesRepository = notesRepository;
        this.ingredientRepository = ingredientRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Recipe> findAll() {
        List<Recipe> recipes = this.recipeRepositoryHibernate.findAll().stream()
                .map(recipeDTO -> {
                    Recipe recipe = this.recipeDtoMapper.recipeDtoToRecipe(recipeDTO);
                    recipe.setNotes(this.notesRepository.findByRecipe(recipe));
                    recipe.setIngredients(this.ingredientRepository.findAllByRecipe(recipe));
                    recipe.setCategory(this.categoryRepository.findAllByRecipe(recipe));
                    return recipe;
                }).collect(Collectors.toList());
        return recipes;
    }

    @Override
    public Recipe findById(Long id) {
        Recipe recipe = this.recipeDtoMapper.recipeDtoToRecipe(this.recipeRepositoryHibernate.findById(id).orElse(null));
        recipe.setNotes(this.notesRepository.findByRecipe(recipe));
        recipe.setIngredients(this.ingredientRepository.findAllByRecipe(recipe));
        recipe.setCategory(this.categoryRepository.findAllByRecipe(recipe));
        return recipe;
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
