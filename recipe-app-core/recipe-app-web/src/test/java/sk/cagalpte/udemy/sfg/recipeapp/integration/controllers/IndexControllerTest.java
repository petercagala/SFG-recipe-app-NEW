package sk.cagalpte.udemy.sfg.recipeapp.integration.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import sk.cagalpte.udemy.sfg.recipeapp.services.RecipeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IndexControllerTest {

    @Autowired
    Model model;

    @Autowired
    RecipeService recipeService;



    @Test
    public void getIndexPage() {
    }
}