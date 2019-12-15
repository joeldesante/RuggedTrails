package com.yooogle.ruggedtrails.listeners;

import com.yooogle.ruggedtrails.managers.BlockManager;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class PlayerListeners implements Listener {

    BlockManager blockManager = new BlockManager();

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {

        Player player = event.getPlayer();

        if(!player.hasPermission("ruggedtrails.trail")) {
            // The player can not make trails and thus should be ignored.
            return;
        }

        // Grab the gamemode for comparison
        GameMode playerGamemode = player.getGameMode();

        // Check the gamemode and apply the appropriate action(s)
        // TODO: Implement a config.yml and allow to disable and enable trails in certain gamemodes

        // Next,
        // Grab the block directly below the player for processing
        Location belowThePlayer = player.getLocation().add(new Vector(0,-1,0));
        Block blockUnderPlayer = belowThePlayer.getBlock();
        Material typeOfBlockUnderPlayer = blockUnderPlayer.getType();

        // Execute some checks (ie. if air, then return.)
        if(typeOfBlockUnderPlayer == Material.AIR) {
            // TODO: Add a config.yml "banned blocks" list
            return;
        }

        // Execute the degradation
        // TODO: Setup a degradation config

        // Code...



    }

}
