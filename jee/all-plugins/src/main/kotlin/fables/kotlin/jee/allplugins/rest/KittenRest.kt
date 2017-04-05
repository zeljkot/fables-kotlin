package fables.kotlin.jee.allplugins.rest

import fables.kotlin.jee.allplugins.Kitten

/**
 * Constructor parameter names mapped to JSON by jackson-module-kotlin.
 * @author Zeljko Trogrlic
 */
data class KittenRest(
        override val name: String,
        override val cuteness: Int
) : Kitten