package com.yooogle.ruggedtrail.listener;

import java.util.List;
import java.util.Random;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import com.yooogle.ruggedtrail.Main;

public class BlockStepListener implements Listener {
	
	// Get Main Class
	Main plugin = Main.getPlugin(Main.class);
	
	// Settings
	float config_prob = (float) plugin.getConfig().getDouble("probability");
	
	@EventHandler
	public void onPlayerStep(PlayerMoveEvent event) {
		
		Player player = event.getPlayer();
		GameMode player_gamemode = player.getGameMode();
		
		switch(player_gamemode) {
			case SURVIVAL:
				if (plugin.getConfig().getBoolean("enable_trails_in_survival") != true) {
					return;	// Player can not make trail
				}
				break;
			
			case CREATIVE:
				if (plugin.getConfig().getBoolean("enable_trails_in_creative") != true) {
					return;	// Player can not make trail
				}
				break;
				
			case ADVENTURE:
				if (plugin.getConfig().getBoolean("enable_trails_in_adventure") != true) {
					return;	// Player can not make trail
				}
				break;
			
			case SPECTATOR:
				if (plugin.getConfig().getBoolean("enable_trails_in_spectator") != true) {
					return;	// Player can not make trail
				}
				break;
		}
		
		// Gets the block directly under the player
		Location below = player.getLocation().add(new Vector(0,-1,0));
		
		// Return if below block is air
		if (below.getBlock().getType() == Material.AIR) {
			return;	
		}
		
		Block block = below.getBlock();
		Material type = block.getType();
		plugin.getLogger().info(type.toString());
		
		// Finds the distance that the player has traveled
		double distance = Math.sqrt(
					Math.pow(event.getTo().getX() - event.getFrom().getBlockX(), 2) + 
					Math.pow(event.getTo().getY() - event.getFrom().getBlockY(), 2) +
					Math.pow(event.getTo().getZ() - event.getFrom().getBlockZ(), 2)
				);
		
		
		// Checks for 5/1000 chances
		float random = new Random().nextFloat();
		
		float probability = config_prob;
				
		if (random <= probability && distance > 0) {
			
			if (canChange("default_path", type)) {
				block.setType(switchType("default_path", type));
			}
		}
	}
	
	/* Utils */
	
	private boolean canChange(String path, Material mat) {
		ConfigurationSection sec = plugin.getConfig().getConfigurationSection(path);
		
		for (String key : sec.getKeys(false)) {
			if (mat.toString().equalsIgnoreCase(key)) {
				return true;
			}
		}
		
		return false;
	}
	
	private Material switchType(String path, Material original) {
		ConfigurationSection sec = plugin.getConfig().getConfigurationSection(path);
		
		for (String key : sec.getKeys(false)) {
			if (original.toString().equalsIgnoreCase(key)) {
				
				List<String> deep_sec = sec.getStringList(key);
				Random r = new Random();
				int deep_sec_len = deep_sec.toArray().length;
				int rand_val = (int)(r.nextFloat() * deep_sec_len);
				
				return Material.getMaterial(deep_sec.toArray()[rand_val].toString());
				
			}
		}
		
		return null;	// NullPointer caused by not listing any changeable types 
	}
	
}
