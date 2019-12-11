package sk.cagalpte.udemy.sfg.recipeapp.services.map;

import java.util.List;

public interface MapService<T, ID> {
    List<T> findAll();

    T findById(ID id);

    T save(T t);

    void delete(T t);

    void deleteById(ID id);
}
