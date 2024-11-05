package org.oreo.fireArrows.utils

import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.block.Block
import org.bukkit.entity.Arrow
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.scheduler.BukkitTask
import org.oreo.fireArrows.FireArrows

object FireArrowUtils {

    val fireArrowPlayerList : MutableMap<Player, BukkitTask> = hashMapOf()

    val fireArrowList : MutableList<Arrow> = mutableListOf()

    fun givePlayerFireArrow(player: Player, block: Block, plugin : FireArrows) {

        val particle = Particle.FLAME
        block.world.spawnParticle(particle, block.location, 10)
        block.world.playSound(player.location, Sound.ENTITY_BLAZE_SHOOT, 1f, 1f)


        val runnable : BukkitTask = object : BukkitRunnable() {
            override fun run(){
                removePlayerFireArrow(player)
            }
        }.runTaskLater(plugin, 20L * plugin.config.getLong("extinguish-time"))

        fireArrowPlayerList[player] = runnable
    }


    fun removePlayerFireArrow(player: Player, wasExtinguished : Boolean = true) {

        if (wasExtinguished) { //Add an extra effects here if you feel like it
            player.world.playSound(player.location,Sound.BLOCK_FIRE_EXTINGUISH, 1f, 1.3f)
        }

        fireArrowPlayerList[player]?.cancel()
        fireArrowPlayerList.remove(player)
    }

}