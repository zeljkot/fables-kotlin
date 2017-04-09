package fables.kotlin.jee.idiomatic.business

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
    private lateinit var entityManager: EntityManager

    operator fun plusAssign(kitten: KittenEntity) = entityManager.persist(kitten) // persist is void anyway

    operator fun get(id: Int): KittenEntity? = entityManager.find(KittenEntity::class.java, id)
}