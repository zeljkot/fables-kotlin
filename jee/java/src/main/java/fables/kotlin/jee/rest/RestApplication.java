package fables.kotlin.jee.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * REST application configuration.
 *
 * @author Zeljko Trogrlic
 */
@ApplicationPath("api")
public class RestApplication
    extends Application {

  private final Set<Class<?>> classes = new HashSet<>(Arrays.asList(KittenRestService.class));

  @Override
  public Set<Class<?>> getClasses() {
    return this.classes;
  }
}
