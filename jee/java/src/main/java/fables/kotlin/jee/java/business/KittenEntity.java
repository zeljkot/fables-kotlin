package fables.kotlin.jee.java.business;

import javax.persistence.*;

/**
 * Persistent kitten.
 *
 * @author Zeljko Trogrlic
 */
@SequenceGenerator(name = "kittens_id_seq", sequenceName = "kittens_id_seq", allocationSize = 1)
@Entity
@Table(name = "kittens")
public class KittenEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kittens_id_seq")
  private Integer id;
  private String  name;
  private int     cuteness;

  protected KittenEntity() {
  }

  public KittenEntity(String name, int cuteness) {
    this.name = name;
    this.cuteness = cuteness;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCuteness() {
    return this.cuteness;
  }

  public void setCuteness(int cuteness) {
    this.cuteness = cuteness;
  }
}
