package sk.cagalpte.udemy.sfg.recipeapp.domain;

import sk.cagalpte.udemy.sfg.recipeapp.enums.Difficulty;

import java.util.Arrays;
import java.util.Objects;

public class Recipe {
    private Long id;

    private String description;

    private Integer prepTime;

    private Integer cookTime;

    private Integer servings;

    private String source;

    private String url;

    private String directions;

    private Byte[] images;

    private Difficulty difficulty;

    public Recipe() {
    }

    public Recipe(Long id, String description, Integer prepTime, Integer cookTime, Integer servings, String source, String url, String directions, Byte[] images, Difficulty difficulty) {
        this.id = id;
        this.description = description;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.servings = servings;
        this.source = source;
        this.url = url;
        this.directions = directions;
        this.images = images;
        this.difficulty = difficulty;
    }

    public Recipe(RecipeBuilder recipeBuilder) {
        this.setId(recipeBuilder.id);
        this.setDescription(recipeBuilder.description);
        this.setPrepTime(recipeBuilder.prepTime);
        this.setCookTime(recipeBuilder.cookTime);
        this.setServings(recipeBuilder.servings);
        this.setSource(recipeBuilder.source);
        this.setUrl(recipeBuilder.url);
        this.setDescription(recipeBuilder.directions);
        this.setImages(recipeBuilder.images);
        this.setDifficulty(recipeBuilder.difficulty);
    }

    public RecipeBuilder createBuilder() {
        return new Recipe.RecipeBuilder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(id, recipe.id) &&
                Objects.equals(description, recipe.description) &&
                Objects.equals(prepTime, recipe.prepTime) &&
                Objects.equals(cookTime, recipe.cookTime) &&
                Objects.equals(servings, recipe.servings) &&
                Objects.equals(source, recipe.source) &&
                Objects.equals(url, recipe.url) &&
                Objects.equals(directions, recipe.directions) &&
                Arrays.equals(images, recipe.images) &&
                difficulty == recipe.difficulty;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, description, prepTime, cookTime, servings, source, url, directions, difficulty);
        result = 31 * result + Arrays.hashCode(images);
        return result;
    }

    public static class RecipeBuilder {
        private Long id;

        private String description;

        private Integer prepTime;

        private Integer cookTime;

        private Integer servings;

        private String source;

        private String url;

        private String directions;

        private Byte[] images;

        private Difficulty difficulty;

        public RecipeBuilder id(Long id) {
            this.id = id;
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

        public Recipe build() {
            return new Recipe(this);
        }


    }
}
