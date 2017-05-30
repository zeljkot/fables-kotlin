package fables.kotlin.jee.rest

import java.util.*
import javax.ws.rs.ApplicationPath
import javax.ws.rs.core.Application

/**
 * REST application configuration.
 * @author Zeljko Trogrlic
 */
@ApplicationPath("api")
class RestApplication : Application() {

    private val classes = HashSet<Class<*>>(Arrays.asList<Class<KittenRestService>>(KittenRestService::class.java))

    override fun getClasses(): Set<Class<*>> {
        return this.classes
    }
}
