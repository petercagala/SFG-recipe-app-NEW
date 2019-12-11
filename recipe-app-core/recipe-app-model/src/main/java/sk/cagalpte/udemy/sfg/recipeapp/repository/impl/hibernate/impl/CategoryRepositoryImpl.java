package sk.cagalpte.udemy.sfg.recipeapp.repository.impl.hibernate.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Category;
import sk.cagalpte.udemy.sfg.recipeapp.repository.CategoryRepository;
import sk.cagalpte.udemy.sfg.recipeapp.repository.impl.hibernate.CategoryRepositoryHibernate;

import java.util.List;

@Profile("hibernate")
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryRepositoryHibernate categoryRepositoryHibernate;

    public CategoryRepositoryImpl(CategoryRepositoryHibernate categoryRepositoryHibernate) {
        this.categoryRepositoryHibernate = categoryRepositoryHibernate;
    }


    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public void delete(Category category) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
