package fables.kotlin.jee.allplugins.business

import javax.ejb.Stateless
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

/**
 * Class and all public methods are opened by Kotlin compiler "allopen" plugin.
 * @author Zeljko Trogrlic
 */
@Stateless
class KittenBusinessService {

    @PersistenceContext
    protected lateinit var entityManager: EntityManager

    operator fun plusAssign(kitten: KittenEntity) {
        entityManager.persist(kitten)
    }

    operator fun get(id: Int): KittenEntity? = entityManager.find(KittenEntity::class.java, id)
}