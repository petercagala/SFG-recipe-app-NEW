package sk.cagalpte.udemy.sfg.recipeapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "unit_of_measure")
@Data
@NoArgsConstructor
public class UnitOfMeasureDto extends BasedEntityDto {

    @Column(name = "UNIT_OF_MEASURE_DESCRIPTION")
    private String unitOfMeasureDescription;

    public UnitOfMeasureDto(UnitOfMeasureDtoBuilder unitOfMeasureDtoBuilder) {
        super(unitOfMeasureDtoBuilder);

        this.setUnitOfMeasureDescription(unitOfMeasureDtoBuilder.unitOfMeasureDescription);
    }

    public UnitOfMeasureDtoBuilder createBuilder() {
        return new UnitOfMeasureDto.UnitOfMeasureDtoBuilder();
    }



    public static class UnitOfMeasureDtoBuilder extends BasedEntityDTOBuilder {
        private String unitOfMeasureDescription;

        public UnitOfMeasureDtoBuilder() {
        }

        @Override
        public UnitOfMeasureDtoBuilder id(Long id) {
             super.id(id);
            return this;
        }

        public UnitOfMeasureDtoBuilder unitOfMeasureDescription(String unitOfMeasure) {
            this.unitOfMeasureDescription = unitOfMeasureDescription;
            return this;
        }

        public UnitOfMeasureDto build() {
            return new UnitOfMeasureDto(this);
        }
    }
}
