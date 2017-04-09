package fables.kotlin.jee.idiomatic.rest

import fables.kotlin.jee.idiomatic.Kitten

/**
 * Constructor parameter names mapped to JSON by jackson-module-kotlin.
 * @author Zeljko Trogrlic
 */
data class KittenRest(
        override val name: String,
        override val cuteness: Int
) : Kitten