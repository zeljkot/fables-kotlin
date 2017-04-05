package fables.kotlin.jee.noplugins.business

import fables.kotlin.jee.noplugins.Kitten
import javax.persistence.*

/**
 * @author Zeljko Trogrlic
 */
@SequenceGenerator(name = "kittens_id_seq", sequenceName = "kittens_id_seq", allocationSize = 1)
@Entity
@Table(name = "kittens")
open class KittenEntity private constructor(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kittens_id_seq")
        open var id: Int?,
        override var name: String,
        override var cuteness: Int // set Int.MAX_VALUE for Nermal
) : Kitten {

    constructor(name: String, cuteness: Int) : this(null, name, cuteness)

    protected constructor() : this(null, "", 5)

    override fun hashCode(): Int {
        return id ?: 0
    }

    override fun equals(other: Any?): Boolean {

        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as KittenEntity

        if (id != other.id) return false
        if (name != other.name) return false
        if (cuteness != other.cuteness) return false

        return true
    }
}