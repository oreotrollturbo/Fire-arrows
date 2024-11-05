package org.oreo.fireArrows.listeners

import com.destroystokyo.paper.event.player.PlayerLaunchProjectileEvent
import org.bukkit.entity.Arrow
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.oreo.fireArrows.utils.FireArrowUtils

class FireArrowShoot : Listener {

    @EventHandler
    fun fireArrowShot(e: PlayerLaunchProjectileEvent){

        if (!FireArrowUtils.fireArrowPlayerList.containsKey(e.player) || e.projectile !is Arrow) return

        e.projectile.isVisualFire = true

        FireArrowUtils.removePlayerFireArrow(player = e.player,false)
        FireArrowUtils.fireArrowList.add(e.projectile as Arrow)
    }

}