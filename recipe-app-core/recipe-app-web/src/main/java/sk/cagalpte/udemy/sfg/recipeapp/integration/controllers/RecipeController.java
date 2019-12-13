package sk.cagalpte.udemy.sfg.recipeapp.integration.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.services.NotesService;
import sk.cagalpte.udemy.sfg.recipeapp.services.RecipeService;

import java.util.List;

@RequestMapping("/recipe")
@Controller
public class RecipeController {

    private final RecipeService recipeService;

    private final NotesService notesService;

    public RecipeController(RecipeService recipeService, NotesService notesService) {
        this.recipeService = recipeService;
        this.notesService = notesService;
    }

    @RequestMapping({"", "/", "index", "index.html"})
    public String getRecipeIndexPage(Model model) {
        List<Recipe> recipes = this.recipeService.findAll();

        model.addAttribute("recipes", recipes);

        return "recipe/index";
    }
}
