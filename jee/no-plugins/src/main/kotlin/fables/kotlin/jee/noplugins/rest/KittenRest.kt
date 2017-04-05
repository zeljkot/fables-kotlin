package fables.kotlin.jee.noplugins.rest

import com.fasterxml.jackson.annotation.JsonProperty
import fables.kotlin.jee.noplugins.Kitten

/**
 * Constructor parameter names must be mapped to JSON names.
 * @author Zeljko Trogrlic
 */
data class KittenRest(
        @JsonProperty("name") override val name: String,
        @JsonProperty("cuteness") override val cuteness: Int
) : Kitten