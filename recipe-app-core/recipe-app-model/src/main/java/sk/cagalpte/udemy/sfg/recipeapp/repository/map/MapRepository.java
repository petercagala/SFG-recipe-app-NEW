package sk.cagalpte.udemy.sfg.recipeapp.repository.map;

import java.util.List;

public interface MapRepository<T, ID> {
    List<T> findAll();

    T findById(ID id);

    T save(T t);

    void delete(T t);

    void deleteById(ID id);
}
