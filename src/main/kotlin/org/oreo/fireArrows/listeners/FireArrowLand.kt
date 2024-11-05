package org.oreo.fireArrows.listeners

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.ProjectileHitEvent
import org.oreo.fireArrows.FireArrows
import org.oreo.fireArrows.utils.FireArrowUtils

class FireArrowLand(private val plugin : FireArrows) : Listener {

    @EventHandler
    fun handleFireArrowLand(e: ProjectileHitEvent) {

        val projectile = e.entity

        if (!FireArrowUtils.fireArrowList.contains(projectile)) return

        FireArrowUtils.fireArrowList.remove(projectile)

        if (e.hitEntity != null){
            e.hitEntity!!.fireTicks = plugin.config.getInt("fire-arrow-brun-time")
        }
    }

}