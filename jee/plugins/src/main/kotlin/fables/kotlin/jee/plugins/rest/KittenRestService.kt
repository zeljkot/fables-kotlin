package fables.kotlin.jee.plugins.rest

import fables.kotlin.jee.plugins.business.KittenBusinessService
import fables.kotlin.jee.plugins.business.KittenEntity
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

/**
 * JSON REST CRud service.
 * JEE will first create one noarg construcotr instance, and then injected constructor instances.
 * @author Zeljko Trogrlic
 */
@Path("kitten")
class KittenRestService @Inject constructor(private val kittenBusinessService: KittenBusinessService) {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun find(
            @PathParam("id") id: Int
    ): KittenRest = kittenBusinessService
            .find(id)
            .map { kittenEntity -> KittenRest(kittenEntity.name, kittenEntity.cuteness) }
            .orElseThrow { NotFoundException("ID $id not found") }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    fun add(kittenRest: KittenRest): Int {
        val kittenEntity = KittenEntity(kittenRest.name, kittenRest.cuteness)
        return kittenBusinessService.add(kittenEntity)
    }
}
