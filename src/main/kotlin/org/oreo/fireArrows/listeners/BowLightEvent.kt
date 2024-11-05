package org.oreo.fireArrows.listeners

import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent
import org.oreo.fireArrows.FireArrows
import org.oreo.fireArrows.utils.FireArrowUtils


class BowLightEvent(private val plugin : FireArrows) : Listener {

    @EventHandler
    fun bowLightEvent(e: PlayerInteractEvent) {

        val player = e.player //Get the player
        val block: Block? = e.clickedBlock //Get the block

        if (!isHoldingBow(player) || !isCorrectBlock(block)) return

        FireArrowUtils.givePlayerFireArrow(player,block!!,plugin)
    }


    /**
     * Makes sure the player is holding a bow
     */
    private fun isHoldingBow(player: Player): Boolean { //What item the player needs to be holding a bow
        return player.inventory.itemInMainHand.type == Material.BOW || player.inventory.itemInMainHand.type == Material.CROSSBOW
    }

    /**
     * Makes sure the player is interacting with the correct block
     */
    private fun isCorrectBlock(block: Block?): Boolean { //Player needs to be interacting with a magma block fire or a campfire
        if (block == null) return false
        return block.blockData.material == Material.FIRE || block.blockData.material == Material.SOUL_CAMPFIRE
    }
}