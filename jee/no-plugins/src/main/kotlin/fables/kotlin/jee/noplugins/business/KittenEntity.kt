package fables.kotlin.jee.noplugins.business

import fables.kotlin.jee.noplugins.Kitten

import javax.persistence.*

/**
 * Persistent kitten.
 * @author Zeljko Trogrlic
 */
@SequenceGenerator(name = "kittens_id_seq", sequenceName = "kittens_id_seq", allocationSize = 1)
@Entity
@Table(name = "kittens")
class KittenEntity : Kitten {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kittens_id_seq")
    var id: Int? = null
    override lateinit var name: String
    override var cuteness: Int = 0

    protected constructor() {}

    constructor(name: String, cuteness: Int) {
        this.name = name
        this.cuteness = cuteness
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }

        val that = o as KittenEntity?

        if (cuteness != that!!.cuteness) {
            return false
        }
        if (id != that.id) {
            return false
        }
        return name == that.name
    }

    override fun hashCode(): Int {
        return id!!.hashCode()
    }

    override fun toString(): String {
        return "KittenEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cuteness=" + cuteness +
                '}'
    }
}
