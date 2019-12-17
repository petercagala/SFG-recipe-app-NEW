package sk.cagalpte.udemy.sfg.recipeapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.cagalpte.udemy.sfg.recipeapp.enums.Difficulty;
import sk.cagalpte.udemy.sfg.recipeapp.mappers.enum_converters.DifficultyConverter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "recipe")
@Data
@NoArgsConstructor
public class RecipeDto extends BasedEntityDto {

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PREP_TIME")
    private Integer prepTime;

    @Column(name = "COOK_TIME")
    private Integer cookTime;

    @Column(name = "SERVINGS")
    private Integer servings;

    @Column(name = "SOURCE")
    private String source;

    @Column(name = "URL")
    private String url;

    @Column(name = "DIRECTIONS")
    @Lob
    private String directions;

    @Column(name = "IMAGES")
    @Lob
    //    @Lob saves the data in BLOB or CLOB. Let�s understand what is BLOB and CLOB
//
//    CLOB(Character Large Object): If data is text and is not enough to save in VARCHAR, then that data should be saved in CLOB.
//
//            BLOB(Binary Large Object): In case of double byte character large data is saved in BLOB data type.
    private Byte[] images;

    //@Enumerated(EnumType.ORDINAL) //1. option (cele cisla podla poradia, default)
//    @Enumerated(EnumType.STRING) //2. option
    @Convert(converter = DifficultyConverter.class) // 3. option (nastavenie skratiek podla jednotlivych enumov)
    private Difficulty difficulty;

    @OneToOne(mappedBy = "recipeDTO", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private NotesDto notesDTO;

    // Nemoze tu byt fetch = FetchType.EAGER
    @OneToMany(mappedBy = "recipeDTO", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IngredientDto> ingredientDTOS = new ArrayList<>();

    @ManyToMany(mappedBy = "recipeDTOS", fetch = FetchType.EAGER)
    private List<CategoryDto> categoryDTOS = new ArrayList<>();


    public RecipeDto(RecipeDTOBuilder recipeDTOBuilder) {
        super(recipeDTOBuilder);

        this.setDescription(recipeDTOBuilder.description);
        this.setPrepTime(recipeDTOBuilder.prepTime);
        this.setCookTime(recipeDTOBuilder.cookTime);
        this.setServings(recipeDTOBuilder.servings);
        this.setSource(recipeDTOBuilder.source);
        this.setUrl(recipeDTOBuilder.url);
        this.setDirections(recipeDTOBuilder.directions);
        this.setImages(recipeDTOBuilder.images);
        this.setDifficulty(recipeDTOBuilder.difficulty);
        this.setCategoryDTOS(recipeDTOBuilder.categoryDTOS);
    }

    public RecipeDTOBuilder createBuilder() {
        return new RecipeDto.RecipeDTOBuilder();
    }



    public static class RecipeDTOBuilder extends BasedEntityDTOBuilder {

        protected String description;

        protected Integer prepTime;

        protected Integer cookTime;

        protected Integer servings;

        protected String source;

        protected String url;

        protected String directions;

        protected Byte[] images;

        protected Difficulty difficulty;

        protected List<CategoryDto> categoryDTOS;

        public RecipeDTOBuilder() {
        }

        @Override
        public RecipeDTOBuilder id(Long id) {
             super.id(id);
            return this;
        }

        public RecipeDTOBuilder description(String description) {
            this.description = description;
            return this;
        }

        public RecipeDTOBuilder prepTime(Integer prepTime) {
            this.prepTime = prepTime;
            return this;
        }

        public RecipeDTOBuilder cookTime(Integer cookTime) {
            this.cookTime = cookTime;
            return this;
        }

        public RecipeDTOBuilder servings(Integer servings) {
            this.servings = servings;
            return this;
        }

        public RecipeDTOBuilder source(String source) {
            this.source = source;
            return this;
        }

        public RecipeDTOBuilder url(String url) {
            this.url = url;
            return this;
        }

        public RecipeDTOBuilder directions(String directions) {
            this.directions = directions;
            return this;
        }

        public RecipeDTOBuilder images(Byte[] images) {
            this.images = images;
            return this;
        }

        public RecipeDTOBuilder difficulty(Difficulty difficulty) {
            this.difficulty = difficulty;
            return this;
        }

        public RecipeDTOBuilder categoryDTOS(List<CategoryDto> categoryDTOS) {
            this.categoryDTOS = categoryDTOS;
            return this;
        }

        public RecipeDto build() {
            return new RecipeDto(this);
        }
    }
}
