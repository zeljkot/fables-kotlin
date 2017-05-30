package fables.kotlin.jee.rest

import fables.kotlin.jee.business.KittenBusinessService
import fables.kotlin.jee.business.KittenEntity
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

/**
 * JSON REST CRud service.
 * Class and all public methods are opened by Kotlin compiler plugin.
 * JEE will first create one noarg constructor instance, and then injected constructor instances.
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
    fun add(
            kittenRest: KittenRest
    ): Int {
        val kittenEntity = KittenEntity(kittenRest.name, kittenRest.cuteness)
        return kittenBusinessService.add(kittenEntity)
    }
}
