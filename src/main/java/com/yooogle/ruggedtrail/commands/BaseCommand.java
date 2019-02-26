package com.yooogle.ruggedtrail.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BaseCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (args.length < 1 || args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("?")) {
			// Display help details
			printHelp(sender);
			
			return true;
		}
		
		if (args[0].equalsIgnoreCase("set")) {
			// If this then the user wants to alter a config value
			
		}
		
		
		
		return true;
	}
	
	private void printHelp(CommandSender sender) {
		sender.sendMessage("RuggedTrails Help: \n "
				+ "- /rtr help OR /rtr ? \n"
				+ "Displays this help message");
	}
	
	
}
