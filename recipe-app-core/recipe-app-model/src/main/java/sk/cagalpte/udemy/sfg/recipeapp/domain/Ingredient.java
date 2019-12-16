package sk.cagalpte.udemy.sfg.recipeapp.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Ingredient extends BaseEntity {

    private String description;

    private BigDecimal amount;

    private UnitOfMeasure unitOfMeasure;

    private Recipe recipe;

    public Ingredient() {
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(description, that.description) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(unitOfMeasure, that.unitOfMeasure) &&
                Objects.equals(recipe, that.recipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description, amount, unitOfMeasure, recipe);
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
