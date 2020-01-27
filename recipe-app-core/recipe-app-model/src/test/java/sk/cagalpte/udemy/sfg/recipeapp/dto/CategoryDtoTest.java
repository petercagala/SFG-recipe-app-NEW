package sk.cagalpte.udemy.sfg.recipeapp.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoryDtoTest {

    CategoryDto categoryDto;

    @Before
    public void setUp() {
        this.categoryDto = new CategoryDto();
    }

    @Test
    public void getId() {
        Long idValue = 4L;

        this.categoryDto.setId(idValue);
        assertEquals(idValue, this.categoryDto.getId());
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void getRecipeDTOS() {
    }
}