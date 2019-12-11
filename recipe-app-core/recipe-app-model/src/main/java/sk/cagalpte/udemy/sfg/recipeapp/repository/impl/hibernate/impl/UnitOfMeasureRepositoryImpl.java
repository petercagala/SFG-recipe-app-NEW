package sk.cagalpte.udemy.sfg.recipeapp.repository.impl.hibernate.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.domain.UnitOfMeasure;
import sk.cagalpte.udemy.sfg.recipeapp.repository.UnitOfMeasureRepository;
import sk.cagalpte.udemy.sfg.recipeapp.repository.impl.hibernate.UnitOfMeasureRepositoryHibernate;

import java.util.List;

@Profile("hibernate")
@Repository
public class UnitOfMeasureRepositoryImpl implements UnitOfMeasureRepository {

    private final UnitOfMeasureRepositoryHibernate unitOfMeasureRepositoryHibernate;

    public UnitOfMeasureRepositoryImpl(UnitOfMeasureRepositoryHibernate unitOfMeasureRepositoryHibernate) {
        this.unitOfMeasureRepositoryHibernate = unitOfMeasureRepositoryHibernate;
    }

    @Override
    public List<UnitOfMeasure> findAll() {
        return null;
    }

    @Override
    public UnitOfMeasure findById(Long id) {
        return null;
    }

    @Override
    public UnitOfMeasure save(UnitOfMeasure unitOfMeasure) {
        return null;
    }

    @Override
    public void delete(UnitOfMeasure unitOfMeasure) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
