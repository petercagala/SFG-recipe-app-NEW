package sk.cagalpte.udemy.sfg.recipeapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@NoArgsConstructor
public class UnitOfMeasure extends BaseEntity {

    @NonNull
    private String unitOfMeasureDescription;

    public UnitOfMeasure(UnitOfMeasureBuilder unitOfMeasureBuilder) {
        super(unitOfMeasureBuilder);

        this.setUnitOfMeasureDescription(unitOfMeasureBuilder.unitOfMeasureDescription);
    }

    public UnitOfMeasureBuilder createBuilder() {
        return new UnitOfMeasure.UnitOfMeasureBuilder();
    }

    public static class UnitOfMeasureBuilder extends BaseEntityBuilder {

        protected String unitOfMeasureDescription;

        @Override
        public UnitOfMeasureBuilder id(Long id) {
             super.id(id);
            return this;
        }

        public UnitOfMeasureBuilder unitOfMeasureDescription(String unitOfMeasureDescription) {
            this.unitOfMeasureDescription = unitOfMeasureDescription;
            return this;
        }

        public UnitOfMeasure build() {
            return new UnitOfMeasure(this);
        }

    }
}
