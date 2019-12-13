package sk.cagalpte.udemy.sfg.recipeapp.repository.impl.hibernate.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Ingredient;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.dto.IngredientDTO;
import sk.cagalpte.udemy.sfg.recipeapp.dto.RecipeDTO;
import sk.cagalpte.udemy.sfg.recipeapp.mappers.dto.IngredientDtoMapper;
import sk.cagalpte.udemy.sfg.recipeapp.mappers.dto.RecipeDtoMapper;
import sk.cagalpte.udemy.sfg.recipeapp.mappers.dto.UnitOfMeasureDtoMapper;
import sk.cagalpte.udemy.sfg.recipeapp.repository.IngredientRepository;
import sk.cagalpte.udemy.sfg.recipeapp.repository.impl.hibernate.IngredientRepositoryHibernate;
import sk.cagalpte.udemy.sfg.recipeapp.repository.impl.hibernate.RecipeRepositoryHibernate;
import sk.cagalpte.udemy.sfg.recipeapp.repository.impl.hibernate.UnitOfMeasureRepositoryHibernate;

import java.util.List;
import java.util.stream.Collectors;

@Profile("hibernate")
@Repository
public class IngredientRepositoryImpl implements IngredientRepository {

    private final IngredientRepositoryHibernate ingredientRepositoryHibernate;

    private final UnitOfMeasureRepositoryHibernate unitOfMeasureRepositoryHibernate;

    private final RecipeRepositoryHibernate recipeRepositoryHibernate;

    private final IngredientDtoMapper ingredientDtoMapper;

    private final UnitOfMeasureDtoMapper unitOfMeasureDtoMapper;

    private final RecipeDtoMapper recipeDtoMapper;

    public IngredientRepositoryImpl(IngredientRepositoryHibernate ingredientRepositoryHibernate, UnitOfMeasureRepositoryHibernate unitOfMeasureRepositoryHibernate, RecipeRepositoryHibernate recipeRepositoryHibernate, IngredientDtoMapper ingredientDtoMapper, UnitOfMeasureDtoMapper unitOfMeasureDtoMapper, RecipeDtoMapper recipeDtoMapper) {
        this.ingredientRepositoryHibernate = ingredientRepositoryHibernate;
        this.unitOfMeasureRepositoryHibernate = unitOfMeasureRepositoryHibernate;
        this.recipeRepositoryHibernate = recipeRepositoryHibernate;
        this.ingredientDtoMapper = ingredientDtoMapper;
        this.unitOfMeasureDtoMapper = unitOfMeasureDtoMapper;
        this.recipeDtoMapper = recipeDtoMapper;
    }

    @Override
    public List<Ingredient> findAll() {
        List<Ingredient> ingredients = this.ingredientRepositoryHibernate.findAll().stream()
                .map(ingredientDTO -> {
                    return this.ingredientDtoMapper.ingredientDtoToIngredient(ingredientDTO);
                }).collect(Collectors.toList());
        return ingredients;
    }

    @Override
    public Ingredient findById(Long id) {
        return this.ingredientDtoMapper.ingredientDtoToIngredient(this.ingredientRepositoryHibernate.findById(id).orElse(null));
    }

    @Override
    public List<Ingredient> findAllByRecipe(Recipe recipe) {
        RecipeDTO recipeDTO = this.recipeRepositoryHibernate.findById(recipe.getId()).orElse(null);
        List<IngredientDTO> ingredientDTOS = this.ingredientRepositoryHibernate
                .findAllByRecipeDTO(recipeDTO);
        List<Ingredient> ingredients = ingredientDTOS.stream()
                .map(ingredientDTO -> {
                    return this.ingredientDtoMapper.ingredientDtoToIngredient(ingredientDTO);
                }).collect(Collectors.toList());
        return ingredients;
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        IngredientDTO ingredientDTO = new IngredientDTO().createBuilder()
                .description(ingredient.getDescription())
                .amount(ingredient.getAmount())
                .unitOfMeasureDTO(this.unitOfMeasureRepositoryHibernate.findById(ingredient.getUnitOfMeasure().getId()).orElse(null))
                .recipeDTO(this.recipeRepositoryHibernate.findById(ingredient.getRecipe().getId()).orElse(null))
                .build();
        IngredientDTO ingredientDtoSaved = this.ingredientRepositoryHibernate.save(ingredientDTO);
        return this.ingredientDtoMapper.ingredientDtoToIngredient(ingredientDtoSaved);
    }

    @Override
    public void delete(Ingredient ingredient) {
        this.ingredientRepositoryHibernate.delete(this.ingredientDtoMapper.ingredintToIngredientDTO(ingredient));
    }

    @Override
    public void deleteById(Long id) {
        this.ingredientRepositoryHibernate.deleteById(id);
    }
}
