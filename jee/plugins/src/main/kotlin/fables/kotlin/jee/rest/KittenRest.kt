package fables.kotlin.jee.rest

import fables.kotlin.jee.Kitten

/**
 * Constructor parameter names mapped to JSON by jackson-module-kotlin.
 * @author Zeljko Trogrlic
 */
data class KittenRest(
        override val name: String,
        override val cuteness: Int
) : Kitten
