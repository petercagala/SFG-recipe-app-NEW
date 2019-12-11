package sk.cagalpte.udemy.sfg.recipeapp.services;

import org.springframework.stereotype.Service;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Category;
import sk.cagalpte.udemy.sfg.recipeapp.services.map.MapService;

@Service
public interface CategoryService extends MapService<Category, Long> {
    public Category findByDescription(String description);
}
