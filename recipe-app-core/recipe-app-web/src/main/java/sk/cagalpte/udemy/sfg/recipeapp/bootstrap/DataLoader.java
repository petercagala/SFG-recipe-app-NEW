package sk.cagalpte.udemy.sfg.recipeapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sk.cagalpte.udemy.sfg.recipeapp.domain.*;
import sk.cagalpte.udemy.sfg.recipeapp.enums.Difficulty;
import sk.cagalpte.udemy.sfg.recipeapp.services.*;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final CategoryService categoryService;

    private final RecipeService recipeService;

    private final UnitOfMeasureService unitOfMeasureService;

    private final NotesService notesService;

    private final IngredientService ingredientService;

    public DataLoader(CategoryService categoryService, RecipeService recipeService, UnitOfMeasureService unitOfMeasureService, NotesService notesService, IngredientService ingredientService) {
        this.categoryService = categoryService;
        this.recipeService = recipeService;
        this.unitOfMeasureService = unitOfMeasureService;
        this.notesService = notesService;
        this.ingredientService = ingredientService;
    }


    @Override
    public void run(String... args) throws Exception {
        Recipe recipe1 = new Recipe().createBuilder()
                .description("Spicy Grilled Chicken Tacos")
                .prepTime(20)
                .cookTime(15)
                .servings(6)
                .directions(DataLoader.recipeDirection1())
                .source("Simply Recipes")
                .difficulty(Difficulty.MODERATE)
                .url("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/")
                .build();
        Recipe recipeSaved1 = this.recipeService.save(recipe1);

        Recipe recipe2 = new Recipe().createBuilder()
                .description("Perfect Guacamole")
                .prepTime(10)
                .cookTime(5)
                .servings(4)
                .directions(DataLoader.recipeDirection2())
                .source("Simply Recipes")
                .difficulty(Difficulty.EASY)
                .url("https://www.simplyrecipes.com/recipes/perfect_guacamole/")
                .build();
        Recipe recipeSaved2 = this.recipeService.save(recipe2);



        Notes notes1 = new Notes().createBuilder()
                .recipe(recipeSaved1)
                .recipeNotes(DataLoader.recipeNotes1())
                .build();
        Notes notes1Saved = this.notesService.save(notes1);

        Notes notes2 = new Notes().createBuilder()
                .recipe(recipeSaved2)
                .recipeNotes(DataLoader.recipeNotes2())
                .build();
        Notes notes2Saved = this.notesService.save(notes2);

        Category category1 = this.categoryService.findById(1L);
        category1.addRecipe(recipeSaved1);
        Category category1Saved = this.categoryService.save(category1);

        Category category2 = this.categoryService.findById(2L);
        category2.addRecipe(recipeSaved1);
        category2.addRecipe(recipeSaved2);
        Category category2Saved = this.categoryService.save(category2);

        Category category3 = this.categoryService.findById(3L);
        category3.addRecipe(recipeSaved1);
        category3.addRecipe(recipeSaved2);
        Category category3Saved = this.categoryService.save(category3);

        Category category4 = this.categoryService.findById(4L);
        category4.addRecipe(recipeSaved1);
        category4.addRecipe(recipeSaved2);
        Category category4Saved = this.categoryService.save(category4);

        UnitOfMeasure unitOfMeasureTeaspoon = this.unitOfMeasureService.findById(1L);
        UnitOfMeasure unitOfMeasureTablespoon = this.unitOfMeasureService.findById(2L);
        UnitOfMeasure unitOfMeasureCup = this.unitOfMeasureService.findById(3L);
        UnitOfMeasure unitOfMeasurePinch = this.unitOfMeasureService.findById(4L);
        UnitOfMeasure unitOfMeasureOunce = this.unitOfMeasureService.findById(5L);

        //1. recipe
        Ingredient ingredientAnchoChiliPowder = new Ingredient().createBuilder()
                .description("ancho chili powder")
                .amount(new BigDecimal(2))
                .unitOfMeasure(unitOfMeasureTablespoon)
                .recipe(recipeSaved1)
                .build();
        Ingredient ingredientAnchoChiliPowderSaved = this.ingredientService.save(ingredientAnchoChiliPowder);

        Ingredient ingredientOregano = new Ingredient().createBuilder()
                .description("dried oregano")
                .amount(new BigDecimal(1))
                .unitOfMeasure(unitOfMeasureTeaspoon)
                .recipe(recipeSaved1)
                .build();
        Ingredient ingredientOreganoSaved = this.ingredientService.save(ingredientOregano);

        Ingredient ingredientCumin = new Ingredient().createBuilder()
                .description("dried cumin")
                .amount(new BigDecimal(1))
                .unitOfMeasure(unitOfMeasureTeaspoon)
                .recipe(recipeSaved1)
                .build();
        Ingredient ingredientCuminSaved = this.ingredientService.save(ingredientCumin);

        Ingredient ingredientSugar = new Ingredient().createBuilder()
                .description("sugar")
                .amount(new BigDecimal(1))
                .unitOfMeasure(unitOfMeasureTeaspoon)
                .recipe(recipeSaved1)
                .build();
        Ingredient ingredientSugarSaved = this.ingredientService.save(ingredientSugar);

        //2. recipe
        Ingredient ingredientAvocados = new Ingredient().createBuilder()
                .description("ripe avocados")
                .amount(new BigDecimal(2))
                .unitOfMeasure(unitOfMeasureOunce)
                .recipe(recipeSaved2)
                .build();
        Ingredient ingredientAvocadosSaved = this.ingredientService.save(ingredientAvocados);

        Ingredient ingredientSalt = new Ingredient().createBuilder()
                .description("Kosher salt")
                .amount(new BigDecimal(1))
                .unitOfMeasure(unitOfMeasureTeaspoon)
                .recipe(recipeSaved2)
                .build();
        Ingredient ingredientSaltSaved = this.ingredientService.save(ingredientSalt);



        List<Recipe> recipesXXX = this.recipeService.findAll();
        Recipe recipeXXX = this.recipeService.findById(1L);


    }

    private static String recipeNotes1() {
        return "Spicy grilled chicken tacos! Quick marinade, then grill. " +
                "Ready in about 30 minutes. Great for a quick weeknight dinner, backyard cookouts, " +
                "and tailgate parties.";
    }

    private static String recipeNotes2() {
        return "The BEST guacamole! EASY to make with ripe avocados, salt, serrano chiles, cilantro and lime." +
                " Garnish with red radishes or jicama. Serve with tortilla chips.";
    }
;
    private static String recipeDirection1() {
        return "1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.";
    }

    private static String  recipeDirection2() {
        return "1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl." +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste." +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.";
    }
}
