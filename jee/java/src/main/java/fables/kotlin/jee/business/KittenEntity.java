package fables.kotlin.jee.business;

import fables.kotlin.jee.Kitten;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Persistent kitten.
 *
 * @author Zeljko Trogrlic
 */
@Entity
public class KittenEntity
    implements Kitten {

  @Id
  @GeneratedValue
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    KittenEntity that = (KittenEntity) o;

    if (cuteness != that.cuteness) {
      return false;
    }
    if (!id.equals(that.id)) {
      return false;
    }
    return name.equals(that.name);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

  @Override
  public String toString() {
    return "KittenEntity{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", cuteness=" + cuteness +
        '}';
  }
}
