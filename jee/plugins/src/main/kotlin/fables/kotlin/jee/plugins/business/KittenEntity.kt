package fables.kotlin.jee.plugins.business

import fables.kotlin.jee.plugins.Kitten

import javax.persistence.*

/**
 * Persistent kitten.
 * @author Zeljko Trogrlic
 */
@SequenceGenerator(name = "kittens_id_seq", sequenceName = "kittens_id_seq", allocationSize = 1)
@Entity
@Table(name = "kittens")
data class KittenEntity private constructor(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kittens_id_seq")
        var id: Int?,
        override var name: String,
        override var cuteness: Int // set Int.MAX_VALUE for Nermal
) : Kitten {

    constructor(name: String, cuteness: Int) : this(null, name, cuteness)
}