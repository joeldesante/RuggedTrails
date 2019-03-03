package com.yooogle.ruggedtrail;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		
		// Load Config
		IntalizeConfig();
		
		// Register Events
		getServer().getPluginManager().registerEvents(new BlockStepListener(), this);
		
		// Register Commands
		//this.getCommand("rtr").setExecutor(new BaseCommand());
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
	// Methods 
	
	public WorldGuardPlugin getWorldGuard() {
		Plugin plugin = getServer().getPluginManager().getPlugin("WorldGuard");
		if ((plugin == null) || (!(plugin instanceof WorldGuardPlugin))) {
			return null;
		}
		
		return (WorldGuardPlugin) plugin;
	}
	
	private void IntalizeConfig() {
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
	}
	
}
