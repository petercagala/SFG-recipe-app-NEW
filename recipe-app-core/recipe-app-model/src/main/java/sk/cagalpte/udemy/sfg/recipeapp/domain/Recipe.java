package sk.cagalpte.udemy.sfg.recipeapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.cagalpte.udemy.sfg.recipeapp.enums.Difficulty;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Recipe extends BaseEntity {

    private String description;

    private Integer prepTime;

    private Integer cookTime;

    private Integer servings;

    private String source;

    private String url;

    private String directions;

    private Byte[] images;

    private Difficulty difficulty;

    private Notes notes;

    private List<Ingredient> ingredients = new ArrayList<>();

    private List<Category> category = new ArrayList<>();


    public Recipe(RecipeBuilder recipeBuilder) {
        super(recipeBuilder);

        this.setDescription(recipeBuilder.description);
        this.setPrepTime(recipeBuilder.prepTime);
        this.setCookTime(recipeBuilder.cookTime);
        this.setServings(recipeBuilder.servings);
        this.setSource(recipeBuilder.source);
        this.setUrl(recipeBuilder.url);
        this.setDirections(recipeBuilder.directions);
        this.setImages(recipeBuilder.images);
        this.setDifficulty(recipeBuilder.difficulty);
        this.setNotes(recipeBuilder.notes);
        this.setIngredients(recipeBuilder.ingredients);
        this.setCategory(recipeBuilder.category);
    }

    public RecipeBuilder createBuilder() {
        return new Recipe.RecipeBuilder();
    }

    public static class RecipeBuilder extends BaseEntityBuilder {

        protected String description;

        protected Integer prepTime;

        protected Integer cookTime;

        protected Integer servings;

        protected String source;

        protected String url;

        protected String directions;

        protected Byte[] images;

        protected Difficulty difficulty;

        protected Notes notes;

        protected List<Ingredient> ingredients = new ArrayList<>();

        protected List<Category> category = new ArrayList<>();

        @Override
        public RecipeBuilder id(Long id) {
             super.id(id);
            return this;
        }

        public RecipeBuilder description(String description) {
            this.description = description;
            return this;
        }

        public RecipeBuilder prepTime(Integer prepTime) {
            this.prepTime = prepTime;
            return this;
        }

        public RecipeBuilder cookTime(Integer cookTime) {
            this.cookTime = cookTime;
            return this;
        }

        public RecipeBuilder servings(Integer servings) {
            this.servings = servings;
            return this;
        }

        public RecipeBuilder source(String source) {
            this.source = source;
            return this;
        }

        public RecipeBuilder url(String url) {
            this.url = url;
            return this;
        }

        public RecipeBuilder directions(String directions) {
            this.directions = directions;
            return this;
        }

        public RecipeBuilder images(Byte[] images) {
            this.images = images;
            return this;
        }

        public RecipeBuilder difficulty(Difficulty difficulty) {
            this.difficulty = difficulty;
            return this;
        }

        public RecipeBuilder notes(Notes notes) {
            this.notes = notes;
            return this;
        }

        public RecipeBuilder addIngredient(Ingredient ingredient) {
            this.ingredients.add(ingredient);
            return this;
        }

        public RecipeBuilder addCategory(Category category) {
            this.category.add(category);
            return this;
        }

        public Recipe build() {
            return new Recipe(this);
        }


    }
}
