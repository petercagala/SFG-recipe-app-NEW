package sk.cagalpte.udemy.sfg.recipeapp.services.impl.hibernate;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Category;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.dto.CategoryDTO;
import sk.cagalpte.udemy.sfg.recipeapp.dto.RecipeDTO;
import sk.cagalpte.udemy.sfg.recipeapp.mappers.dto.CategoryDtoMapper;
import sk.cagalpte.udemy.sfg.recipeapp.mappers.dto.RecipeDtoMapper;
import sk.cagalpte.udemy.sfg.recipeapp.repositories.CategoryRepositoryHibernate;
import sk.cagalpte.udemy.sfg.recipeapp.repositories.RecipeRepositoryHibernate;
import sk.cagalpte.udemy.sfg.recipeapp.services.CategoryRepService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Profile("hibernate")
@Service
public class CategoryRepServiceImpl implements CategoryRepService {

    private final CategoryRepositoryHibernate categoryRepositoryHibernate;

    private final CategoryDtoMapper categoryDtoMapper;

    private final RecipeRepositoryHibernate recipeRepositoryHibernate;

    private final RecipeDtoMapper recipeDtoMapper;

    public CategoryRepServiceImpl(CategoryRepositoryHibernate categoryRepositoryHibernate, CategoryDtoMapper categoryDtoMapper, RecipeRepositoryHibernate recipeRepositoryHibernate, RecipeDtoMapper recipeDtoMapper) {
        this.categoryRepositoryHibernate = categoryRepositoryHibernate;
        this.categoryDtoMapper = categoryDtoMapper;
        this.recipeRepositoryHibernate = recipeRepositoryHibernate;
        this.recipeDtoMapper = recipeDtoMapper;
    }


    @Override
    public List<Category> findAll() {
        List<Category> categories = this.categoryRepositoryHibernate.findAll().stream()
                .map(categoryDTO -> {
                    return this.categoryDtoMapper.categoryDtoToCategory(categoryDTO);
                }).collect(Collectors.toList());
        return categories;
    }

    @Override
    public Category findById(Long id) {
        return this.categoryDtoMapper.categoryDtoToCategory(this.categoryRepositoryHibernate.findById(id).orElse(null));
    }

    @Override
    public List<Category> findAllByRecipe(Recipe recipe) {
        RecipeDTO recipeDTO = this.recipeRepositoryHibernate.findById(recipe.getId()).orElse(null);
        List<CategoryDTO> categoryDTOS = this.categoryRepositoryHibernate.findAllByRecipeDTOS(recipeDTO);
        List<Category> categories = categoryDTOS.stream()
                .map(categoryDTO -> {
                    return this.categoryDtoMapper.categoryDtoToCategory(categoryDTO);
                }).collect(Collectors.toList());
        return categories;
    }

    @Override
    public Category findByDescription(String description) {
        return this.categoryDtoMapper.categoryDtoToCategory(this.categoryRepositoryHibernate.findByDescription(description).orElse(null));
    }

    @Override
    public Category save(Category category) {
        List<RecipeDTO> recipeDTOS = new ArrayList<>();
        for(Recipe recipe: category.getRecipes()) {
            recipeDTOS.add(this.recipeRepositoryHibernate.findById(recipe.getId()).orElse(null));
        }

        CategoryDTO categoryDTO = new CategoryDTO().createBuilder()
                .description(category.getDescription())
                .recipeDTOS(recipeDTOS)
                .build();
        CategoryDTO categoryDTOSaved = this.categoryRepositoryHibernate.save(categoryDTO);

        return this.categoryDtoMapper.categoryDtoToCategory(categoryDTOSaved);
    }

    @Override
    public void delete(Category category) {
        this.categoryRepositoryHibernate.delete(this.categoryDtoMapper.categoryToCategoryDTO(category));
    }

    @Override
    public void deleteById(Long id) {
        this.categoryRepositoryHibernate.deleteById(id);
    }
}
