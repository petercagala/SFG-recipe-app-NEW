package sk.cagalpte.udemy.sfg.recipeapp.domain;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Category {

    @Nullable
    private Long id;

    @NonNull
    private String description;

    private List<Recipe> recipes = new ArrayList<>();

    public Category() {
    }

    public Category(@Nullable Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Category(CategoryBuilder categoryBuilder) {
        this.setId(categoryBuilder.id);
        this.setDescription(categoryBuilder.description);
        this.setRecipes(categoryBuilder.recipes);
    }

    public CategoryBuilder createBuilder() {
        return new Category.CategoryBuilder();
    }

    @Nullable
    public Long getId() {
        return id;
    }

    public void setId(@Nullable Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public void addRecipe(Recipe recipe) {
        this.recipes.add(recipe);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) &&
                Objects.equals(description, category.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    public static class CategoryBuilder {
        private Long id;

        private String description;

        private List<Recipe> recipes = new ArrayList<>();

        public CategoryBuilder() {
        }

        public CategoryBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CategoryBuilder description(String description) {
            this.description = description;
            return this;
        }

        public CategoryBuilder recipes(List<Recipe> recipes) {
            this.recipes = recipes;
            return this;
        }

        public Category build() {
            return new Category(this);
        }
    }
}
