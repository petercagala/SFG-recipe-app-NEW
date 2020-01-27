package sk.cagalpte.udemy.sfg.recipeapp.services.impl.hibernate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.dto.RecipeDto;
import sk.cagalpte.udemy.sfg.recipeapp.mappers.dto.RecipeDtoMapper;
import sk.cagalpte.udemy.sfg.recipeapp.repositories.RecipeRepositoryHibernate;
import sk.cagalpte.udemy.sfg.recipeapp.services.RecipeRepService;

import java.util.List;

import static org.junit.Assert.assertEquals;

// !!! ak chces pracovat s beanmi pri testovani, musis mat @RunWith a @SpringBootTest a zaroven, pre dany modul
// @SpringBootApplication, alebo @SpringBootConfiguration (co je to iste ak @SpringBootApplication, len mozes tam bachat konfiguraky)
// @SpringBootApplication mozes nastavit pre kazdy modul ak ich mas viac. Z pohladu testovania to nestaci spravit len pre jeden modul
// plus nastav application.properties pre testovanie zvlast
@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeRepServiceImplTest {

    @Autowired
//    @Mock
    RecipeRepService recipeRepService;

    //    @Mock mi neviem preco zatial nefunguje
    @Autowired
    RecipeRepositoryHibernate recipeRepositoryHibernate;

    @Autowired
    RecipeDtoMapper recipeDtoMapper;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    //
    @Test
    public void findAll() {
        Recipe recipe1 = new Recipe().createBuilder()
                .description("my recipe 1")
                .build();
        RecipeDto recipeDto1 = this.recipeDtoMapper.recipeToRecipeDto(recipe1);

        Recipe recipe2 = new Recipe().createBuilder()
                .description("my recipe 2")
                .build();
        RecipeDto recipeDto2 = this.recipeDtoMapper.recipeToRecipeDto(recipe2);

        this.recipeRepositoryHibernate.save(recipeDto1);
        this.recipeRepositoryHibernate.save(recipeDto2);
        List<Recipe> recipesSaved1 = this.recipeRepService.findAll();


        assertEquals(2L, recipesSaved1.size());
    }
}