package net.hynse.waterthing.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Levelled;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import net.hynse.waterthing.Waterthing;

public class WaterSourceListener implements Listener {
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onWaterFlow(BlockFromToEvent event) {
        Block block = event.getBlock();
        Block toBlock = event.getToBlock();
        
        if (block.getType() != Material.WATER) {
            return;
        }

        // Check if we're in a river biome
        String biomeName = toBlock.getBiome().toString().toLowerCase();
        if (!biomeName.contains("river")) {
            return;
        }

        BlockData blockData = block.getBlockData();
        if (!(blockData instanceof Levelled)) {
            return;
        }

        Levelled levelledBlock = (Levelled) blockData;
        
        // If it's a source block (level 0), prevent it from flowing
        if (levelledBlock.getLevel() == 0) {
            event.setCancelled(true);
        }
    }
}