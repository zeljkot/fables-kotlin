package fables.kotlin.jee.rest;

import fables.kotlin.jee.business.KittenBusinessService;
import fables.kotlin.jee.business.KittenEntity;

import javax.inject.Inject;
import javax.ws.rs.*;

/**
 * JSON REST CRud service.
 * JEE will first create one noarg instance, and then injected instances.
 *
 * @author Zeljko Trogrlic
 */
@Path("kitten")
public class KittenRestService {

  @Inject
  protected KittenBusinessService kittenBusinessService;

  @GET
  @Path("{id}")
  @Produces({"application/json"})
  public KittenRest find(
      @PathParam("id") final int id
  ) {
    return kittenBusinessService
        .find(id)
        .map(kittenEntity -> new KittenRest(kittenEntity.getName(), kittenEntity.getCuteness()))
        .orElseThrow(() -> new NotFoundException("ID " + id + " not found"));
  }

  @POST
  @Produces({"application/json"})
  public Integer add(KittenRest kittenRest) {
    KittenEntity kittenEntity = new KittenEntity(kittenRest.getName(), kittenRest.getCuteness());
    return kittenBusinessService.add(kittenEntity);
  }
}
