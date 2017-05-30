package fables.kotlin.jee.business

import javax.ejb.Stateless
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

/**
 * CRud kitten operations.
 * Class and all public methods are opened by Kotlin compiler "allopen" plugin.
 * @author Zeljko Trogrlic
 */
@Stateless
class KittenBusinessService {

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    operator fun plusAssign(kitten: KittenEntity) =
            entityManager.persist(kitten) // persist is void anyway; id will be updated

    operator fun get(id: Int): KittenEntity? =
            entityManager.find(KittenEntity::class.java, id)
}
