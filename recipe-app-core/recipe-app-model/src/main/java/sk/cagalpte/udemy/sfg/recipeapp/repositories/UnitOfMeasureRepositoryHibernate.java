package sk.cagalpte.udemy.sfg.recipeapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.dto.UnitOfMeasureDto;

import java.util.Optional;

@Repository
public interface UnitOfMeasureRepositoryHibernate extends JpaRepository<UnitOfMeasureDto, Long> {

    public Optional<UnitOfMeasureDto> findByUnitOfMeasureDescription(String unitOfMeasureDescription);
}
