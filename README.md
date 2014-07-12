# Electry - Minecrell's ten.java submission

[![ten.java](https://cdn.mediacru.sh/hu4CJqRD7AiB.svg)](https://tenjava.com/)

This is a submission for the 2014 ten.java contest.

- __Theme:__ How can energy be harnessed and used in the Minecraft world?
- __Time:__ Time 2 (7/12/2014 09:00 to 7/12/2014 19:00 UTC)
- __MC Version:__ 1.7.9-R0.2
- __Stream URL:__ None :/

---------------------------------------

## About Electry
Electry adds electrical energy to the game. While it wasn't possible (for me) to complete it within the provided
 time it adds some new blocks and machines. It is similar to Minecraft mods like IndustrialCraft, 
 but it does not require any Client mods or resource packs. Currently it adds 4 new blocks to the game:
 
- Solar Cell - Generates new energy from the sun light.
- Electrial Furnace - Smelts items using electrical energy.
- Redstone Cable - A cable using redstone wires. (Only craftable - does nothing at the moment)
- Tripwire Cable - A cable using tripwires. (Only craftable - does nothing at the moment)

### Features
These features have actually been implemented within the time frame:

- Basic API / skeleton for adding multiple different electrial machines easier.
- Basic Solar Cell powering nearly Electrial Furnaces. (Below, or to on of the sides.)
    - The efficiency calculation is slightly bugged because there is no reliable function in the Bukkit API to 
    get the light level made by the sun/moon. It is possible to detect whether the block is direct under the sky
     or in the underground, but there is no way to split the light made by torches or the Electrical Furnace 
     itself from the provided light level. That's why the Solar Cells are completely disabled in the night at 
     the moment - in the future, however this should be rewritten to use a better algorithm.
- Basic Electrical Furnace smelting items without additionally fuel. It will be powered by a near Solar Cell.
    - It is not completely save - sometimes it might be possible to "remove" the energy from the furnace.
- Storage of the blocks at runtime.
    - The blocks and their data are saved using Bukkit MetaData at runtime. Currently they are not saved to 
    disk, however first preparations for this have been already made. It is planned that the blocks are written 
    to the disk if the world is saves and unloaded when the chunks are unloaded to adopt Minecraft's default 
    behaviour.

### Crafting Recipes
Please take a look at [this imgur album](http://imgur.com/a/qIUyc).

### Example

![](http://i.imgur.com/CfgbAEt.png)

### Planned Features
Electry is far away from being complete. Even though not that many features have been added within the time 
frame of the ten.java contest, I'm planning to complete it after it. Here are some of my ideas:

- Add the cables for energy transportation (with additional distance some energy will get lost)
- Improve the efficiency calculation for the Solar Cells.
- Implement the persistent storage with a database or YAML/JSON files.
- Add more machines, configuration, maybe let the electrical furnaces work faster.
- Implement some kind of enchanting to improve the machines.

---------------------------------------

## Compilation

- Download & Install [Maven 3](http://maven.apache.org/download.html)
- Clone the repository: `git clone https://github.com/tenjava/Minecrell-t2.git`
- Compile and create the plugin package using Maven: `mvn`

Maven will download all required dependencies and build a ready-for-use plugin package!
