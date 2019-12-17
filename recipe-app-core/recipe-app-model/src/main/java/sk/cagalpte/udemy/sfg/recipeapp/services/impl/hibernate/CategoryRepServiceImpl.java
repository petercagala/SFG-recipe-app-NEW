package sk.cagalpte.udemy.sfg.recipeapp.services.impl.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Category;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.dto.CategoryDto;
import sk.cagalpte.udemy.sfg.recipeapp.dto.RecipeDto;
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
@Slf4j
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
        // Project Lombok
        log.debug("I'm in the CategoryRepServiceImpl: logger provided by Project Lombok");

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
        RecipeDto recipeDTO = this.recipeRepositoryHibernate.findById(recipe.getId()).orElse(null);
        List<CategoryDto> categoryDTOS = this.categoryRepositoryHibernate.findAllByRecipeDTOS(recipeDTO);
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
        List<RecipeDto> recipeDTOS = new ArrayList<>();
        for(Recipe recipe: category.getRecipes()) {
            recipeDTOS.add(this.recipeRepositoryHibernate.findById(recipe.getId()).orElse(null));
        }

        CategoryDto categoryDTO = new CategoryDto().createBuilder()
                .description(category.getDescription())
                .recipeDTOS(recipeDTOS)
                .build();
        CategoryDto categoryDTOSaved = this.categoryRepositoryHibernate.save(categoryDTO);

        return this.categoryDtoMapper.categoryDtoToCategory(categoryDTOSaved);
    }

    @Override
    public void delete(Category category) {
        this.categoryRepositoryHibernate.delete(this.categoryDtoMapper.categoryToCategoryDto(category));
    }

    @Override
    public void deleteById(Long id) {
        this.categoryRepositoryHibernate.deleteById(id);
    }
}
