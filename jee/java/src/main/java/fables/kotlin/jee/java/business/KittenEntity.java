package fables.kotlin.jee.java.business;

import fables.kotlin.jee.java.Kitten;

import javax.persistence.*;

/**
 * Persistent kitten.
 *
 * @author Zeljko Trogrlic
 */
@SequenceGenerator(name = "kittens_id_seq", sequenceName = "kittens_id_seq", allocationSize = 1)
@Entity
@Table(name = "kittens")
public class KittenEntity
    implements Kitten {

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
