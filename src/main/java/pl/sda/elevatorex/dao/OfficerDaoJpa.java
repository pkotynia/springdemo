package pl.sda.elevatorex.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import pl.sda.elevatorex.model.OfficerJpa;

import java.util.List;
import java.util.Optional;

@Repository
public class OfficerDaoJpa implements OfficerDao<OfficerJpa> {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public OfficerJpa save(OfficerJpa officer) {
        entityManager.persist(officer);
        return officer;
    }

    @Override
    public Optional<OfficerJpa> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(OfficerJpa.class, id));
    }

    @Override
    public List<OfficerJpa> findAll() {
        return entityManager.createQuery("Select o from OfficerJpa o", OfficerJpa.class)
                .getResultList();
    }

    @Override
    public long count() {
        return entityManager.createQuery("Select count(o,id) from OfficerJpa o", Long.class)
                .getSingleResult();
    }

    @Override
    public void delete(OfficerJpa officer) {
        entityManager.remove(officer);
    }
}
