package fables.kotlin.jee.noplugins.business

import javax.ejb.Stateless
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

/**
 * @author Zeljko Trogrlic
 */
@Stateless
open class KittenBusinessService {

    @PersistenceContext
    protected lateinit var entityManager: EntityManager

    open fun add(kitten: KittenEntity) = kitten
            .also { entityManager.persist(it) }
            .id!!

    open fun find(id: Int) = entityManager.find(KittenEntity::class.java, id)
}