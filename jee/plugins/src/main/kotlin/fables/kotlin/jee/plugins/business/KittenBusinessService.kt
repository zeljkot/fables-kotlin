package fables.kotlin.jee.plugins.business

import java.util.*
import javax.ejb.Stateless
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

/**
 * CRud kitten operations.
 *
 * @author Zeljko Trogrlic
 */
@Stateless
class KittenBusinessService {

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    fun add(kitten: KittenEntity): Int {
        entityManager.persist(kitten)
        return kitten.id!!
    }

    fun find(id: Int): Optional<KittenEntity> =
            Optional.ofNullable(entityManager.find(KittenEntity::class.java, id))
}
