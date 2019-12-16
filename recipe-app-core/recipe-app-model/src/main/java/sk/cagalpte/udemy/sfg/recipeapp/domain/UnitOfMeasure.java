package sk.cagalpte.udemy.sfg.recipeapp.domain;

import org.springframework.lang.NonNull;

import java.util.Objects;

public class UnitOfMeasure extends BaseEntity {

    @NonNull
    private String unitOfMeasureDescription;

    public UnitOfMeasure() {
    }

    public UnitOfMeasure(UnitOfMeasureBuilder unitOfMeasureBuilder) {
        super(unitOfMeasureBuilder);

        this.setUnitOfMeasureDescription(unitOfMeasureBuilder.unitOfMeasureDescription);
    }

    public UnitOfMeasureBuilder createBuilder() {
        return new UnitOfMeasure.UnitOfMeasureBuilder();
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
        UnitOfMeasure that = (UnitOfMeasure) o;
        return Objects.equals(unitOfMeasureDescription, that.unitOfMeasureDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), unitOfMeasureDescription);
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
