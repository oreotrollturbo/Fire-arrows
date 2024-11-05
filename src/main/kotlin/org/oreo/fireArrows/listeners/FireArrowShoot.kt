package org.oreo.fireArrows.listeners

import com.destroystokyo.paper.event.player.PlayerLaunchProjectileEvent
import org.bukkit.entity.Arrow
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.ProjectileLaunchEvent
import org.oreo.fireArrows.utils.FireArrowUtils

class FireArrowShoot : Listener {

    @EventHandler
    fun fireArrowShot(e: ProjectileLaunchEvent){

        if (!FireArrowUtils.fireArrowPlayerList.containsKey(e.entity.shooter) || e.entity !is Arrow ||
            e.entity.shooter !is Player) return

        e.entity.isVisualFire = true

        FireArrowUtils.removePlayerFireArrow(player = e.entity.shooter as Player,false)
        FireArrowUtils.fireArrowList.add(e.entity as Arrow)
    }

}