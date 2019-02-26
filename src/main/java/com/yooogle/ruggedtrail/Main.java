package com.yooogle.ruggedtrail;

import org.bukkit.plugin.java.JavaPlugin;

import com.yooogle.ruggedtrail.commands.BaseCommand;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		
		// Register Events
		getServer().getPluginManager().registerEvents(new BlockStepListener(), this);
		
		// Register Commands
		this.getCommand("test").setExecutor(new BaseCommand());
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
}
