package sk.cagalpte.udemy.sfg.recipeapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Data
@NoArgsConstructor
public class BasedEntityDto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public BasedEntityDto(BasedEntityDTOBuilder basedEntityDTOBuilder) {
        this.setId(basedEntityDTOBuilder.id);
    }

    public BasedEntityDTOBuilder createBuilder() {
        return new BasedEntityDto.BasedEntityDTOBuilder();
    }


    public static class BasedEntityDTOBuilder {
        protected Long id;

        public BasedEntityDTOBuilder() {
        }

        public BasedEntityDTOBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public BasedEntityDto build() {
            return new BasedEntityDto(this);
        }
    }
}
