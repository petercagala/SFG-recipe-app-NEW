package sk.cagalpte.udemy.sfg.recipeapp.dto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "ingredient")
public class IngredientDTO extends BasedEntityDTO {

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    // V triede UnitOfMeasureDTO abslutne ziadnu asociaciu nedavame v tomto pripade, nechceme totiz absolutne ziadnu kaskadu medzi nimi
    // thi is UNIDIRECTIONAL relationship: one side (UnitOfMeasureDTO side) will not know about the other
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UNIT_OF_MEASURE_ID")
    private UnitOfMeasureDTO unitOfMeasureDTO;

    @ManyToOne
    @JoinColumn(name = "RECIPE_ID", foreignKey = @ForeignKey(name = "FK_ingredient_RECIPE_ID"))
    private RecipeDTO recipeDTO;

    public IngredientDTO() {
    }

    public IngredientDTO(IngredientDTOBuilder ingredientDTOBuilder) {
        super(ingredientDTOBuilder);

        this.setDescription(ingredientDTOBuilder.description);
        this.setAmount(ingredientDTOBuilder.amount);
        this.setRecipeDTO(ingredientDTOBuilder.recipeDTO);
        this.setUnitOfMeasureDTO(ingredientDTOBuilder.unitOfMeasureDTO);
    }

    public IngredientDTOBuilder createBuilder() {
        return new IngredientDTO.IngredientDTOBuilder();
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

    public RecipeDTO getRecipeDTO() {
        return recipeDTO;
    }

    public void setRecipeDTO(RecipeDTO recipeDTO) {
        this.recipeDTO = recipeDTO;
    }

    public UnitOfMeasureDTO getUnitOfMeasureDTO() {
        return unitOfMeasureDTO;
    }

    public void setUnitOfMeasureDTO(UnitOfMeasureDTO unitOfMeasureDTO) {
        this.unitOfMeasureDTO = unitOfMeasureDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        IngredientDTO that = (IngredientDTO) o;
        return Objects.equals(description, that.description) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(unitOfMeasureDTO, that.unitOfMeasureDTO) &&
                Objects.equals(recipeDTO, that.recipeDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description, amount, unitOfMeasureDTO, recipeDTO);
    }

    public static class IngredientDTOBuilder extends BasedEntityDTOBuilder {

        protected String description;

        protected BigDecimal amount;

        protected  UnitOfMeasureDTO unitOfMeasureDTO;

        protected RecipeDTO recipeDTO;

        public IngredientDTOBuilder() {
        }

        @Override
        public IngredientDTOBuilder id(Long id) {
             super.id(id);
            return this;
        }

        public IngredientDTOBuilder description(String description) {
            this.description = description;
            return this;
        }

        public IngredientDTOBuilder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public IngredientDTOBuilder unitOfMeasureDTO(UnitOfMeasureDTO unitOfMeasureDTO) {
            this.unitOfMeasureDTO = unitOfMeasureDTO;
            return this;
        }

        public IngredientDTOBuilder recipeDTO(RecipeDTO recipeDTO) {
            this.recipeDTO = recipeDTO;
            return this;
        }

        public IngredientDTO build() {
            return new IngredientDTO(this);
        }
    }
}
