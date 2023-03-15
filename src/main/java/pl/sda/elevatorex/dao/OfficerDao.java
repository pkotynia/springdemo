package pl.sda.elevatorex.dao;

import pl.sda.elevatorex.model.Officer;

import java.util.List;
import java.util.Optional;

public interface OfficerDao<T> {

    T save(T officer);

    Optional<T> findById(Integer id);

    List<T> findAll();

    long count();

    void delete(T officer);
}
