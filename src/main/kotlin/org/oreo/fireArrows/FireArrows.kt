package org.oreo.fireArrows

import org.bukkit.plugin.java.JavaPlugin
import org.oreo.fireArrows.listeners.AntiTeleport
import org.oreo.fireArrows.listeners.BowLightEvent
import org.oreo.fireArrows.listeners.FireArrowLand
import org.oreo.fireArrows.listeners.FireArrowShoot

class FireArrows : JavaPlugin() {

    override fun onEnable() {

        saveDefaultConfig()

        server.pluginManager.registerEvents(BowLightEvent(this), this)
        server.pluginManager.registerEvents(FireArrowShoot(), this)
        server.pluginManager.registerEvents(FireArrowLand(this), this)
        server.pluginManager.registerEvents(AntiTeleport(), this)

    }
}
