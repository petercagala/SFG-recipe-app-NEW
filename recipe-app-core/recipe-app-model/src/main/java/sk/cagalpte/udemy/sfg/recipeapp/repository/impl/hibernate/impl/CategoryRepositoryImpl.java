package sk.cagalpte.udemy.sfg.recipeapp.repository.impl.hibernate.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Category;
import sk.cagalpte.udemy.sfg.recipeapp.dto.CategoryDTO;
import sk.cagalpte.udemy.sfg.recipeapp.mappers.dto.CategoryDtoMapper;
import sk.cagalpte.udemy.sfg.recipeapp.repository.CategoryRepository;
import sk.cagalpte.udemy.sfg.recipeapp.repository.impl.hibernate.CategoryRepositoryHibernate;

import java.util.List;
import java.util.stream.Collectors;

@Profile("hibernate")
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryRepositoryHibernate categoryRepositoryHibernate;

    private final CategoryDtoMapper categoryDtoMapper;

    public CategoryRepositoryImpl(CategoryRepositoryHibernate categoryRepositoryHibernate, CategoryDtoMapper categoryDtoMapper) {
        this.categoryRepositoryHibernate = categoryRepositoryHibernate;
        this.categoryDtoMapper = categoryDtoMapper;
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
    public Category findByDescription(String description) {
        return this.categoryDtoMapper.categoryDtoToCategory(this.categoryRepositoryHibernate.findByDescription(description).orElse(null));
    }

    @Override
    public Category save(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO().createBuilder()
                .description(category.getDescription())
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
