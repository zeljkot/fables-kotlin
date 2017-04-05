package fables.kotlin.jee.java.business;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

/**
 * CRud kitten operations.
 *
 * @author Zeljko Trogrlic
 */
@Stateless
public class KittenBusinessService {

  @PersistenceContext
  protected EntityManager entityManager;

  public Integer add(KittenEntity kitten) {
    entityManager.persist(kitten);
    return kitten.getId();
  }

  public Optional<KittenEntity> find(int id) {
    return Optional.ofNullable(entityManager.find(KittenEntity.class, id));
  }
}
