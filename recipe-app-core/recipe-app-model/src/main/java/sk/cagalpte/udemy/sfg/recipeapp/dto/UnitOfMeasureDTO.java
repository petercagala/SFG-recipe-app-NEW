package sk.cagalpte.udemy.sfg.recipeapp.dto;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "unit_of_measure")
public class UnitOfMeasureDTO extends BasedEntityDTO {

    @Column(name = "UNIT_OF_MEASURE_DESCRIPTION")
    private String unitOfMeasureDescription;

    public UnitOfMeasureDTO() {
    }

    public UnitOfMeasureDTO(UnitOfMeasureDtoBuilder unitOfMeasureDtoBuilder) {
        super(unitOfMeasureDtoBuilder);

        this.setUnitOfMeasureDescription(unitOfMeasureDtoBuilder.unitOfMeasureDescription);
    }

    public UnitOfMeasureDtoBuilder createBuilder() {
        return new UnitOfMeasureDTO.UnitOfMeasureDtoBuilder();
    }

    public String getUnitOfMeasureDescription() {
        return unitOfMeasureDescription;
    }

    public void setUnitOfMeasureDescription(String unitOfMeasureDescription) {
        this.unitOfMeasureDescription = unitOfMeasureDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UnitOfMeasureDTO that = (UnitOfMeasureDTO) o;
        return Objects.equals(unitOfMeasureDescription, that.unitOfMeasureDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), unitOfMeasureDescription);
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

        public UnitOfMeasureDTO build() {
            return new UnitOfMeasureDTO(this);
        }
    }
}
