package fables.kotlin.jee.plugins.rest

import fables.kotlin.jee.plugins.Kitten

/**
 * Kitten data transfer object.
 * @author Zeljko Trogrlic
 */
data class KittenRest(
        override val name: String,
        override val cuteness: Int
) : Kitten
