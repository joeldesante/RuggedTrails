package com.yooogle.ruggedtrail;

import org.bukkit.plugin.java.JavaPlugin;

import com.yooogle.ruggedtrail.commands.BaseCommand;

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
	
	private void IntalizeConfig() {
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
	}
	
}
