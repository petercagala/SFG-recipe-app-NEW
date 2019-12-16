package sk.cagalpte.udemy.sfg.recipeapp.domain;

import java.io.Serializable;
import java.util.Objects;

public class BaseEntity implements Serializable {
    private Long id;

    public BaseEntity() {
    }

    public BaseEntity(BaseEntityBuilder baseEntityBuilder) {
        this.setId(baseEntityBuilder.id);
    }

    public BaseEntityBuilder createBuilder() {
        return new BaseEntity.BaseEntityBuilder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static class BaseEntityBuilder {
        protected Long id;

        public BaseEntityBuilder() {
        }

        public BaseEntityBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public BaseEntity build() {
            return new BaseEntity(this);
        }
    }
}
