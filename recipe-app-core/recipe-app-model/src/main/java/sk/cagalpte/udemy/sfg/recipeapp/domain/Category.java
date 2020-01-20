package sk.cagalpte.udemy.sfg.recipeapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

//@Builder
@Data
@NoArgsConstructor
public class Category extends BaseEntity {

    private String description;

    private List<Recipe> recipes = new ArrayList<>();


    public Category(CategoryBuilder categoryBuilder) {
        super(categoryBuilder);

        this.setDescription(categoryBuilder.description);
        this.setRecipes(categoryBuilder.recipes);
    }

    public void addRecipe(Recipe recipe) {
        this.recipes.add(recipe);
    }

    public CategoryBuilder createBuilder() {
        return new Category.CategoryBuilder();
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

        public CategoryBuilder addRecipe(Recipe recipe) {
            this.recipes.add(recipe);
            return this;
        }

        public Category build() {
            return new Category(this);
        }
    }
}
