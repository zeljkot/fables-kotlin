package fables.kotlin.jee.rest

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import javax.ws.rs.ApplicationPath
import javax.ws.rs.core.Application
import javax.ws.rs.ext.ContextResolver

/**
 * REST application configuration.
 * Jakson KotlinModule is registered here.
 * @author Zeljko Trogrlic
 */
@ApplicationPath("api")
class RestApplication : Application() {

    // TIP: it is not possible to override Java getter with Kotlin getter
    // This does not work: open val classes = setOf(KittenRestService::class.java)
    private val classes = setOf(KittenRestService::class.java)

    private val singletons = setOf(MyContextResolver())

    override fun getClasses() = classes

    override fun getSingletons() = singletons
}

class MyContextResolver : ContextResolver<ObjectMapper> {

    val objectMapper = ObjectMapper()

    init {
        objectMapper.registerModule(KotlinModule())
    }

    override fun getContext(p0: Class<*>?) = objectMapper
}
