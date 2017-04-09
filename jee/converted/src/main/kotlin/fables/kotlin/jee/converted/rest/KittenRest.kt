package fables.kotlin.jee.converted.rest

import com.fasterxml.jackson.annotation.JsonProperty
import fables.kotlin.jee.converted.Kitten

/**
 * Kitten data transfer object.
 * On deserialization, default constructor properties cannot be mapped without @JsonProperty annotations.
 * @author Zeljko Trogrlic
 */
data class KittenRest(
        @param:JsonProperty("name") override val name: String,
        @param:JsonProperty("cuteness") override val cuteness: Int
) : Kitten
