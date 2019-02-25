package com.yooogle.ruggedtrail;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		
		getServer().getPluginManager().registerEvents(new BlockStepListener(), this);
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
}
