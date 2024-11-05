package org.oreo.fireArrows.listeners

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerTeleportEvent
import org.oreo.fireArrows.utils.FireArrowUtils.fireArrowPlayerList
import org.oreo.fireArrows.utils.FireArrowUtils.removePlayerFireArrow

class AntiTeleport : Listener {

    /**
     * Making sure no tricks with warping happen
     */
    @EventHandler
    fun onTeleport(e: PlayerTeleportEvent) {

        if (!fireArrowPlayerList.containsKey(e.player)) return

        removePlayerFireArrow(e.player)
    }

}