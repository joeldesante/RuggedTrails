> This project is not currently being activly maintained

# RuggedTrails

![Example Snapshot](https://i.imgur.com/rK8xQS2.jpg)

## What Does It Do?
This super lightweight plugin will simulate wear and tear on different path materials. For instance, if you walk over stone, there will be a 5/1000 chace that it will degrade into cobblestone. Then from there it will become coarse dirt, and then finnaly dirt.

It should be noted that ALL BLOCKS on the following list WILL DEGRADE if stepped on... Thus, if you use this plugin, I advise that all floors that use one of the following materials be made of slabs instead of full blocks.

### These blocks degrade:
  - Stone (EXCLUDES slab form)
  - Cobblestone (EXCLUDES slab form)
  - Andesite, Diorite, Granite (Does NOT include polished versions of the block)
  - Grass
  - Coarse Dirt


### Permissions:
```
ruggedtrails.trail:
    description: Allows a player to create a trail.
    default: true
    note: In order to deny a player the ability to create a trail,
              just negate the permission.
```
