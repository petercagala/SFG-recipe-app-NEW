package sk.cagalpte.udemy.sfg.recipeapp.services.impl.hibernate;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.dto.RecipeDto;
import sk.cagalpte.udemy.sfg.recipeapp.mappers.dto.RecipeDtoMapper;
import sk.cagalpte.udemy.sfg.recipeapp.repositories.RecipeRepositoryHibernate;
import sk.cagalpte.udemy.sfg.recipeapp.services.CategoryRepService;
import sk.cagalpte.udemy.sfg.recipeapp.services.IngredientRepService;
import sk.cagalpte.udemy.sfg.recipeapp.services.NotesRepService;
import sk.cagalpte.udemy.sfg.recipeapp.services.RecipeRepService;

import java.util.List;
import java.util.stream.Collectors;

@Profile("hibernate")
@Service
public class RecipeRepServiceImpl implements RecipeRepService {

    private final RecipeRepositoryHibernate recipeRepositoryHibernate;

    private final RecipeDtoMapper recipeDtoMapper;

    private final NotesRepService notesRepService;

    private final IngredientRepService ingredientRepService;

    private final CategoryRepService categoryRepService;



    public RecipeRepServiceImpl(RecipeRepositoryHibernate recipeRepositoryHibernate, RecipeDtoMapper recipeDtoMapper, NotesRepService notesRepService, IngredientRepService ingredientRepService, CategoryRepService categoryRepService) {
        this.recipeRepositoryHibernate = recipeRepositoryHibernate;
        this.recipeDtoMapper = recipeDtoMapper;
        this.notesRepService = notesRepService;
        this.ingredientRepService = ingredientRepService;
        this.categoryRepService = categoryRepService;
    }


    @Override
    public List<Recipe> findAll() {
        List<Recipe> recipes = this.recipeRepositoryHibernate.findAll().stream()
                .map(recipeDTO -> {
                    Recipe recipe = this.recipeDtoMapper.recipeDtoToRecipe(recipeDTO);
                    recipe.setNotes(this.notesRepService.findByRecipe(recipe));
                    recipe.setIngredients(this.ingredientRepService.findAllByRecipe(recipe));
                    recipe.setCategory(this.categoryRepService.findAllByRecipe(recipe));
                    return recipe;
                }).collect(Collectors.toList());
        return recipes;
    }

    @Override
    public Recipe findById(Long id) {
        Recipe recipe = this.recipeDtoMapper.recipeDtoToRecipe(this.recipeRepositoryHibernate.findById(id).orElse(null));
        recipe.setNotes(this.notesRepService.findByRecipe(recipe));
        recipe.setIngredients(this.ingredientRepService.findAllByRecipe(recipe));
        recipe.setCategory(this.categoryRepService.findAllByRecipe(recipe));
        return recipe;
    }

    @Override
    public Recipe save(Recipe recipe) {
        RecipeDto recipeDTO = new RecipeDto().createBuilder()
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
        RecipeDto recipeDtoSaved = this.recipeRepositoryHibernate.save(recipeDTO);
        return this.recipeDtoMapper.recipeDtoToRecipe(recipeDtoSaved);
    }

    @Override
    public void delete(Recipe recipe) {
        this.recipeRepositoryHibernate.delete(this.recipeDtoMapper.recipeToRecipeDto(recipe));
    }

    @Override
    public void deleteById(Long id) {
        this.recipeRepositoryHibernate.deleteById(id);
    }
}
