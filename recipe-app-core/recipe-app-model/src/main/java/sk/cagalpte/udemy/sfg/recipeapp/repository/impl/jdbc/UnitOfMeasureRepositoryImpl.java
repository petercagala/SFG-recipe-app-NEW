package sk.cagalpte.udemy.sfg.recipeapp.repository.impl.jdbc;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.domain.UnitOfMeasure;
import sk.cagalpte.udemy.sfg.recipeapp.repository.UnitOfMeasureRepository;

import java.util.List;

@Profile("jdbc")
@Repository
public class UnitOfMeasureRepositoryImpl implements UnitOfMeasureRepository {
    @Override
    public List<UnitOfMeasure> findAll() {
        return null;
    }

    @Override
    public UnitOfMeasure findById(Long id) {
        return null;
    }

    @Override
    public UnitOfMeasure findByUnitOfMeasureDescription(String unitOfMeasureDescription) {
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
