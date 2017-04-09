package fables.kotlin.jee.converted.rest

import fables.kotlin.jee.converted.business.KittenBusinessService
import fables.kotlin.jee.converted.business.KittenEntity
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

/**
 * JSON REST CRud service.
 * JEE will first create one noarg instance, and then injected instances.
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
            @PathParam("id") id: Int
    ): KittenRest = kittenBusinessService
            .find(id)
            .map { kittenEntity -> KittenRest(kittenEntity.name, kittenEntity.cuteness) }
            .orElseThrow { NotFoundException("ID $id not found") }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    open fun add(kittenRest: KittenRest): Int {
        val kittenEntity = KittenEntity(kittenRest.name, kittenRest.cuteness)
        return kittenBusinessService.add(kittenEntity)
    }
}
