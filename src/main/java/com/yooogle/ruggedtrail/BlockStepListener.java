package com.yooogle.ruggedtrail;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class BlockStepListener implements Listener {
	
	@EventHandler
	public void onPlayerStep(PlayerMoveEvent event) {
		
		Location below = new Location(event.getPlayer().getWorld(), event.getTo().getX(), Math.ceil(event.getTo().getY() - 1), event.getTo().getZ());
		Block block = below.getBlock();
		Material type = block.getType();
		
		/*
		 * This variable is not needed at this time. So I have
		 * commented it out so that I am not using unneeded resources.
		 *
		
		double distance = Math.sqrt(
					Math.pow(event.getTo().getX() - event.getFrom().getX(), 2) + 
					Math.pow(event.getTo().getY() - event.getFrom().getY(), 2) +
					Math.pow(event.getTo().getZ() - event.getFrom().getZ(), 2)
				);
		*/
		
		
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
		float probability = 0.005f;
		
		if (random <= probability) {
			
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
