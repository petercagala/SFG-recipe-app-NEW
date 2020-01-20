package sk.cagalpte.udemy.sfg.recipeapp.integration.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Category;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.domain.UnitOfMeasure;
import sk.cagalpte.udemy.sfg.recipeapp.services.CategoryService;
import sk.cagalpte.udemy.sfg.recipeapp.services.RecipeService;
import sk.cagalpte.udemy.sfg.recipeapp.services.UnitOfMeasureService;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("")
public class IndexController {
    private final CategoryService categoryService;

    private final RecipeService recipeService;

    private final UnitOfMeasureService unitOfMeasureService;

    public IndexController(CategoryService categoryService, RecipeService recipeService, UnitOfMeasureService unitOfMeasureService) {
        this.categoryService = categoryService;
        this.recipeService = recipeService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @RequestMapping({"", "/", "index", "index.html"})
    public String getIndexPage(Model model) {
        log.debug("Getting index page");

        Category categories = this.categoryService.findByDescription("American");
        List<Recipe> recipes = this.recipeService.findAll();
        UnitOfMeasure unitOfMeasure = this.unitOfMeasureService.findByUnitOfMeasureDescription("Teaspoon");
        model.addAttribute("categories", categories);
        model.addAttribute("unitOfMeasure", unitOfMeasure);
        model.addAttribute("recipes",recipes);

        return "index";
    }


}
