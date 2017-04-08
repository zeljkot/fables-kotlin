package fables.kotlin.jee.java.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import fables.kotlin.jee.java.Kitten;

/**
 * Kitten data transfer object.
 *
 * @author Zeljko Trogrlic
 */
public class KittenRest
    implements Kitten {

  private final String name;
  private final int    cuteness;

  public String getName() {
    return this.name;
  }

  public int getCuteness() {
    return this.cuteness;
  }

  /**
   * Default constructor.
   * On deserialization, properties cannot be mapped without @JsonProperty annotations.
   */
  public KittenRest(
      @JsonProperty("name") String name,
      @JsonProperty("cuteness") int cuteness
  ) {
    this.name = name;
    this.cuteness = cuteness;
  }
}
