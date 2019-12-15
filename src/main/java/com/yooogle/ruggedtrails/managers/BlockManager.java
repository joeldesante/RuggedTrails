package com.yooogle.ruggedtrails.managers;

import org.bukkit.block.Block;

import java.util.HashMap;

public class BlockManager {

    private HashMap<Block, Integer> blockTracker = new HashMap<Block, Integer>();

    public int getBlockWear(Block block) {
        /**
         * @param block - The block in which you'de like to check.
         * @return The amount of times a given block has been stepped on.
         */

        if(!blockTracker.containsKey(block)) {
            blockTracker.put(block, 0);
            return 0;
        }

        return blockTracker.get(block);
    }

    public void setBlockWear(Block block, int amount) {
        /**
         * @param block - The block in which you'de like to set.
         * @param amount - The amount in which you'de like to set.
         */

        blockTracker.put(block, amount);
    }

    public void increaseBlockWear(Block block, int amount) {

        /**
         * @param block - The block in which you'de like to set.
         * @param amount - The amount in which you'de like to set.
         */

        if(!blockTracker.containsKey(block)) {
            this.setBlockWear(block, amount);
        }

        int originalValue = blockTracker.get(block);
        blockTracker.put(block, originalValue + amount);

    }

    public void decreaseBlockWear(Block block, int amount) {

        /**
         * @param block - The block in which you'de like to set.
         * @param amount - The amount in which you'de like to set.
         */

        if(!blockTracker.containsKey(block)) {
            this.setBlockWear(block, amount * -1);
        }

        int originalValue = blockTracker.get(block);
        blockTracker.put(block, originalValue - amount);
    }


}
