package fables.kotlin.jee.java.rest;

import fables.kotlin.jee.java.business.KittenBusinessService;
import fables.kotlin.jee.java.business.KittenEntity;

import javax.inject.Inject;
import javax.ws.rs.*;

/**
 * Class demonstrates constructor injection.
 * Very clumsy in Java.
 * It is included for a reference; it is not used in the project.
 *
 * @author Zeljko Trogrlic
 */
@Path("kitten")
public class KittenRestServiceConstructor {

  protected final KittenBusinessService kittenBusinessService;

  /**
   * Used once before first call.
   */
  public KittenRestServiceConstructor() {
    kittenBusinessService = null;
  }

  /**
   * Used for each call.
   */
  @Inject
  public KittenRestServiceConstructor(KittenBusinessService kittenBusinessService) {
    this.kittenBusinessService = kittenBusinessService;
  }

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
