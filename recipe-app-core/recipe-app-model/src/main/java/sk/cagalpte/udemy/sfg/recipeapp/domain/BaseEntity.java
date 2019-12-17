package sk.cagalpte.udemy.sfg.recipeapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class BaseEntity implements Serializable {
    private Long id;

    public BaseEntity(BaseEntityBuilder baseEntityBuilder) {
        this.setId(baseEntityBuilder.id);
    }

    public BaseEntityBuilder createBuilder() {
        return new BaseEntity.BaseEntityBuilder();
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
