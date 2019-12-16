package sk.cagalpte.udemy.sfg.recipeapp.domain;

import sk.cagalpte.udemy.sfg.recipeapp.enums.Difficulty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    public Recipe() {
    }


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Byte[] getImages() {
        return images;
    }

    public void setImages(Byte[] images) {
        this.images = images;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(description, recipe.description) &&
                Objects.equals(prepTime, recipe.prepTime) &&
                Objects.equals(cookTime, recipe.cookTime) &&
                Objects.equals(servings, recipe.servings) &&
                Objects.equals(source, recipe.source) &&
                Objects.equals(url, recipe.url) &&
                Objects.equals(directions, recipe.directions) &&
                Arrays.equals(images, recipe.images) &&
                difficulty == recipe.difficulty &&
                Objects.equals(notes, recipe.notes) &&
                Objects.equals(ingredients, recipe.ingredients) &&
                Objects.equals(category, recipe.category);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), description, prepTime, cookTime, servings, source, url, directions, difficulty, notes, ingredients, category);
        result = 31 * result + Arrays.hashCode(images);
        return result;
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
