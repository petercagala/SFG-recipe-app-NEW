package sk.cagalpte.udemy.sfg.recipeapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "ingredient")
@Data
@NoArgsConstructor
public class IngredientDto extends BasedEntityDto {

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    // V triede UnitOfMeasureDTO abslutne ziadnu asociaciu nedavame v tomto pripade, nechceme totiz absolutne ziadnu kaskadu medzi nimi
    // thi is UNIDIRECTIONAL relationship: one side (UnitOfMeasureDTO side) will not know about the other
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UNIT_OF_MEASURE_ID")
    private UnitOfMeasureDto unitOfMeasureDTO;

    @ManyToOne
    @JoinColumn(name = "RECIPE_ID", foreignKey = @ForeignKey(name = "FK_ingredient_RECIPE_ID"))
    private RecipeDto recipeDTO;

    public IngredientDto(IngredientDTOBuilder ingredientDTOBuilder) {
        super(ingredientDTOBuilder);

        this.setDescription(ingredientDTOBuilder.description);
        this.setAmount(ingredientDTOBuilder.amount);
        this.setRecipeDTO(ingredientDTOBuilder.recipeDTO);
        this.setUnitOfMeasureDTO(ingredientDTOBuilder.unitOfMeasureDTO);
    }

    public IngredientDTOBuilder createBuilder() {
        return new IngredientDto.IngredientDTOBuilder();
    }

    public static class IngredientDTOBuilder extends BasedEntityDTOBuilder {

        protected String description;

        protected BigDecimal amount;

        protected UnitOfMeasureDto unitOfMeasureDTO;

        protected RecipeDto recipeDTO;

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

        public IngredientDTOBuilder unitOfMeasureDTO(UnitOfMeasureDto unitOfMeasureDTO) {
            this.unitOfMeasureDTO = unitOfMeasureDTO;
            return this;
        }

        public IngredientDTOBuilder recipeDTO(RecipeDto recipeDTO) {
            this.recipeDTO = recipeDTO;
            return this;
        }

        public IngredientDto build() {
            return new IngredientDto(this);
        }
    }
}
