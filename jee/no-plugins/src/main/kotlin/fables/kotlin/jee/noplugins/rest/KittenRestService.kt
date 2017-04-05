package fables.kotlin.jee.noplugins.rest

import fables.kotlin.jee.noplugins.business.KittenBusinessService
import fables.kotlin.jee.noplugins.business.KittenEntity
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

/**
 * All non-private methods and variables (val and var) must be open.
 * @author Zeljko Trogrlic
 */
@Path("kitten")
open class KittenRestService {

    /**
     * Value will be injected after the object is constructed, so it must be lateinit or nullable.
     * As it should always get value, lateinit is more appropriate.
     * It also means less null checks in code.
     */
    @Inject
    private lateinit var kittenBusinessService: KittenBusinessService

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    open fun find(
            @PathParam("id")
            id: Int
    ) = kittenBusinessService
            .find(id)
            ?.let { KittenRest(it.name, it.cuteness) }
            ?: throw NotFoundException("ID $id not found")

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    open fun add(
            kittenRest: KittenRest
    ) = kittenRest
            .let { KittenEntity(kittenRest.name, kittenRest.cuteness) }
            .let { kittenBusinessService.add(it) }
}