package sk.cagalpte.udemy.sfg.recipeapp.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
public class BasedEntityDTO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public BasedEntityDTO() {
    }

    public BasedEntityDTO(BasedEntityDTOBuilder basedEntityDTOBuilder) {
        this.setId(basedEntityDTOBuilder.id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BasedEntityDTOBuilder createBuilder() {
        return new BasedEntityDTO.BasedEntityDTOBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasedEntityDTO that = (BasedEntityDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static class BasedEntityDTOBuilder {
        protected Long id;

        public BasedEntityDTOBuilder() {
        }

        public BasedEntityDTOBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public BasedEntityDTO build() {
            return new BasedEntityDTO(this);
        }
    }
}
