package sk.cagalpte.udemy.sfg.recipeapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Ingredient extends BaseEntity {

    private String description;

    private BigDecimal amount;

    private UnitOfMeasure unitOfMeasure;

    private Recipe recipe;

    public Ingredient(IngredientBuilder ingredientBuilder) {
        super(ingredientBuilder);

        this.setDescription(ingredientBuilder.description);
        this.setAmount(ingredientBuilder.amount);
        this.setUnitOfMeasure(ingredientBuilder.unitOfMeasure);
        this.setRecipe(ingredientBuilder.recipe);
    }

    public IngredientBuilder createBuilder() {
        return new Ingredient.IngredientBuilder();
    }

    public static class IngredientBuilder extends BaseEntityBuilder {
        protected String description;

        protected BigDecimal amount;

        protected UnitOfMeasure unitOfMeasure;

        protected Recipe recipe;

        public IngredientBuilder() {
        }

        @Override
        public IngredientBuilder id(Long id) {
             super.id(id);
            return this;
        }

        public IngredientBuilder description(String description) {
            this.description = description;
            return this;
        }

        public IngredientBuilder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public IngredientBuilder recipe(Recipe recipe) {
            this.recipe = recipe;
            return this;
        }

        public IngredientBuilder unitOfMeasure(UnitOfMeasure unitOfMeasure) {
            this.unitOfMeasure = unitOfMeasure;
            return this;
        }

        public Ingredient build() {
            return new Ingredient(this);
        }


    }
}
