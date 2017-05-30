package fables.kotlin.jee.business

import fables.kotlin.jee.Kitten
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Persistent kitten.
 * @author Zeljko Trogrlic
 */
@Entity
data class KittenEntity private constructor(
        @Id
        @GeneratedValue
        var id: Int?,
        override var name: String,
        override var cuteness: Int // set Int.MAX_VALUE for Nermal
) : Kitten {

    private constructor() : this(null, "", 0)

    constructor(name: String, cuteness: Int) : this(null, name, cuteness)
}
