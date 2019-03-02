package com.yooogle.ruggedtrail;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class BlockStepListener implements Listener {
	
	// Get Main Class
	Main plugin = Main.getPlugin(Main.class);
	
	// Settings
	float config_prob = (float) plugin.getConfig().getDouble("probability");
	
	@EventHandler
	public void onPlayerStep(PlayerMoveEvent event) {
		
		// Gets the block directly under the player
		Location below = new Location(event.getPlayer().getWorld(), event.getTo().getX(), Math.ceil(event.getTo().getY() - 1), event.getTo().getZ());
		
		// Checks to see if the below block is air, if so then see if the next block is not
		// (Makes it better for sprint jumping players)
		if (below.getBlock().getType() == Material.AIR) {
			below = new Location(event.getPlayer().getWorld(), event.getTo().getX(), Math.ceil(event.getTo().getY() - 3), event.getTo().getZ());
			
			//Check if the block is under another block
			Material above = below.getWorld().getBlockAt(new Location(below.getWorld(), below.getX(), below.getY() + 1, below.getZ())).getType();
			if (above != Material.AIR && above != Material.WATER && above != Material.LAVA) {
				// Something important is above this
				return;
			}
			
		}
		
		Block block = below.getBlock();
		Material type = block.getType();
		
		// Finds the distance that the player has traveled
		double distance = Math.sqrt(
					Math.pow(event.getTo().getX() - event.getFrom().getX(), 2) + 
					Math.pow(event.getTo().getY() - event.getFrom().getY(), 2) +
					Math.pow(event.getTo().getZ() - event.getFrom().getZ(), 2)
				);
		
		
		Material[] changable = {
				Material.STONE,
				Material.COBBLESTONE,
				Material.GRAVEL,
				Material.GRASS_BLOCK,
				Material.ANDESITE,
				Material.DIORITE,
				Material.GRANITE,
				Material.COARSE_DIRT,
				Material.DIRT
		};
		
		// Checks for 5/1000 chances
		float random = new Random().nextFloat();
		
		float probability = config_prob;
		
		if (random <= probability && distance > 0) {
			
			if (hasMaterial(changable, type)) {
				block.setType(Material.DIRT);
				
				switch(type) {
					
					// Set to Cobblestone 
					case STONE:
						block.setType(Material.COBBLESTONE);
						break;
						
					// This section all turns to coarse dirt
					case COBBLESTONE:
						block.setType(Material.COARSE_DIRT);
						break;
						
					case GRAVEL:
						block.setType(Material.COARSE_DIRT);
						break;
						
					case GRASS_BLOCK:
						block.setType(Material.COARSE_DIRT);
						break;
						
					case ANDESITE:
						block.setType(Material.COARSE_DIRT);
						break;
						
					case DIORITE:
						block.setType(Material.COARSE_DIRT);
						break;
						
					case GRANITE:
						block.setType(Material.COARSE_DIRT);
						break;
						
					// Turn to Dirt
					case COARSE_DIRT:
						block.setType(Material.DIRT);
						break;
					
					// Do Nothing
					default:
						break;
				}
			}
		}
	}
	
	/* Utils */
	
	// Checks if an array has the material we are looking for
	private Boolean hasMaterial(Material[] arr, Material type) {
		for (int i = 0; i < arr.length; i++) {
			if (type == arr[i]) {
				return true;
			}
		}
		
		return false;
	}
	
}
