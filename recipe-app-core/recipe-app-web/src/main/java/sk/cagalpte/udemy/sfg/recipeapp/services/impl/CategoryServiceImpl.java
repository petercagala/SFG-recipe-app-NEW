package sk.cagalpte.udemy.sfg.recipeapp.services.impl;

import org.springframework.stereotype.Service;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Category;
import sk.cagalpte.udemy.sfg.recipeapp.services.CategoryRepService;
import sk.cagalpte.udemy.sfg.recipeapp.services.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepService categoryRepService;

    public CategoryServiceImpl(CategoryRepService categoryRepService) {
        this.categoryRepService = categoryRepService;
    }

    @Override
    public Category findByDescription(String description) {
        return this.categoryRepService.findByDescription(description);
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepService.findAll();
    }

    @Override
    public Category findById(Long id) {
        return this.categoryRepService.findById(id);
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepService.save(category);
    }

    @Override
    public void delete(Category category) {
        this.categoryRepService.delete(category);
    }

    @Override
    public void deleteById(Long id) {
        this.categoryRepService.deleteById(id);
    }
}
