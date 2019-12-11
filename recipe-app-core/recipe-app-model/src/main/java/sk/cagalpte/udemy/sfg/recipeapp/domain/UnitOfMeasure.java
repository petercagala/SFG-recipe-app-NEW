package sk.cagalpte.udemy.sfg.recipeapp.domain;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Objects;

public class UnitOfMeasure {

    @Nullable
    private Long id;

    @NonNull
    private String unitOfMeasureDescription;

    public UnitOfMeasure() {
    }

    public UnitOfMeasure(@Nullable Long id, String unitOfMeasureDescription) {
        this.id = id;
        this.unitOfMeasureDescription = unitOfMeasureDescription;
    }

    public UnitOfMeasure(UnitOfMeasureBuilder unitOfMeasureBuilder) {
        this.setId(unitOfMeasureBuilder.id);
        this.setUnitOfMeasureDescription(unitOfMeasureBuilder.unitOfMeasureDescription);
    }

    public UnitOfMeasureBuilder createBuilder() {
        return new UnitOfMeasure.UnitOfMeasureBuilder();
    }

    @Nullable
    public Long getId() {
        return id;
    }

    public void setId(@Nullable Long id) {
        this.id = id;
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
        UnitOfMeasure that = (UnitOfMeasure) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(unitOfMeasureDescription, that.unitOfMeasureDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, unitOfMeasureDescription);
    }

    public static class UnitOfMeasureBuilder {
        private Long id;

        private String unitOfMeasureDescription;

        public UnitOfMeasureBuilder id(Long id) {
            this.id = id;
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
