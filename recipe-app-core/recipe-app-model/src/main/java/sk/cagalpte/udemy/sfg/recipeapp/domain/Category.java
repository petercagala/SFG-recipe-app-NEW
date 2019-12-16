package sk.cagalpte.udemy.sfg.recipeapp.domain;

import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Category extends BaseEntity {

    @NonNull
    private String description;

    private List<Recipe> recipes = new ArrayList<>();

    public Category() {
    }

    public Category(CategoryBuilder categoryBuilder) {
        super(categoryBuilder);

        this.setDescription(categoryBuilder.description);
        this.setRecipes(categoryBuilder.recipes);
    }

    public CategoryBuilder createBuilder() {
        return new Category.CategoryBuilder();
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
        if (!super.equals(o)) return false;
        Category category = (Category) o;
        return Objects.equals(description, category.description) &&
                Objects.equals(recipes, category.recipes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description, recipes);
    }

    public static class CategoryBuilder extends BaseEntityBuilder {

        protected String description;

        protected List<Recipe> recipes = new ArrayList<>();

        public CategoryBuilder() {
        }

        @Override
        public CategoryBuilder id(Long id) {
             super.id(id);
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
