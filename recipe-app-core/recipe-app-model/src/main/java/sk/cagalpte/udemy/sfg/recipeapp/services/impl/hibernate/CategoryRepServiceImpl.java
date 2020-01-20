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
        CategoryDto categoryDto  = this.categoryRepositoryHibernate.findByDescription(description).orElse(null);

        Category category = this.categoryDtoMapper.categoryDtoToCategory(categoryDto);
        categoryDto.getRecipeDTOS().stream().forEach(recipeDto -> {
            category.addRecipe(this.recipeDtoMapper.recipeDtoToRecipe(recipeDto));
        });

        return category;
    }

    @Override
    public Category save(Category category) {
        List<RecipeDto> recipeDTOS = new ArrayList<>();
        for(Recipe recipe: category.getRecipes()) {
            if(!(this.recipeRepositoryHibernate.findById(recipe.getId()).orElse(null) == null)) {
                recipeDTOS.add(this.recipeRepositoryHibernate.findById(recipe.getId()).orElse(null));
            }
        }

        CategoryDto categoryDTOActuallySaved = this.categoryRepositoryHibernate.findById(category.getId()).orElse(null);

        CategoryDto categoryDTO;
        if(categoryDTOActuallySaved == null) {
            categoryDTO = new CategoryDto().createBuilder()
                    .description(category.getDescription())
                    .recipeDTOS(recipeDTOS)
                    .build();
        } else {
            categoryDTO = new CategoryDto().createBuilder()
                    .id(categoryDTOActuallySaved.getId())
                    .description(category.getDescription())
                    .recipeDTOS(recipeDTOS)
                    .build();
        }

        CategoryDto categoryDTOSaved = this.categoryRepositoryHibernate.save(categoryDTO);

        Category categorySaved = this.categoryDtoMapper.categoryDtoToCategory(categoryDTOSaved);
        categoryDTOSaved.getRecipeDTOS().stream().forEach(recipeDto -> {
            categorySaved.addRecipe(this.recipeDtoMapper.recipeDtoToRecipe(recipeDto));
        });

        return categorySaved;
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
