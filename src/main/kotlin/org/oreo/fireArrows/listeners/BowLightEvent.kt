package org.oreo.fireArrows.listeners

import net.kyori.adventure.text.Component
import org.bukkit.ChatColor
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
        System.out.println("bow light event1")
        if (!isHoldingBow(player) || !isCorrectBlock(block)) return
        System.out.println("bow light event2")
        //Remove an item from their inventory

        //We want to remove one coal block from the player inventory as a cost to light
        //the arrow on fire.

        val inventory = player.inventory

        if (inventory.contains(Material.COAL_BLOCK)) {
            val slot = inventory.first(Material.COAL_BLOCK)
            val itemStack = inventory.getItem(slot)
            itemStack!!.amount = itemStack.amount - 1
            inventory.setItem(slot,itemStack)
            System.out.println("bow light event3")
        }else{
            player.sendActionBar(Component.text(ChatColor.RED.toString() + "You need a coal block to set ur arrow aflame!"))
            return
        }
        System.out.println("bow light event4")
        FireArrowUtils.givePlayerFireArrow(player,block!!,plugin)
    }


    /**
     * Makes sure the player is holding a bow
     */
    private fun isHoldingBow(player: Player): Boolean { //What item the player needs to be holding a bow
        System.out.println("bow light event5 " + player.inventory.itemInMainHand.type)
        return player.inventory.itemInMainHand.type == Material.BOW || player.inventory.itemInMainHand.type == Material.CROSSBOW

    }

    /**
     * Makes sure the player is interacting with the correct block
     */
    private fun isCorrectBlock(block: Block?): Boolean { //Player needs to be interacting with a magma block fire or a campfire
        if (block == null) return false
        return block.blockData.material == Material.CAMPFIRE
    }
}