package fables.kotlin.jee.noplugins.rest

import javax.ws.rs.ApplicationPath
import javax.ws.rs.core.Application

/**
 * REST application configuration.
 * @author Zeljko Trogrlic
 */
@ApplicationPath("api")
class RestApplication : Application() {

    // TIP: it is not possible to override Java getter with Kotlin getter
    // This does not work: open val classes = setOf(KittenRestService::class.java)
    private val classes = setOf(KittenRestService::class.java)

    override fun getClasses() = classes
}
