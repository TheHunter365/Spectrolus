package net.thehunter365.spectroworld.storage;

import net.thehunter365.spectroworldapi.shem.AbstractBlock;
import net.thehunter365.spectroworldapi.shem.AbstractSchematic;
import net.thehunter365.spectroworldapi.shem.loc.AbstractLocation;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class SchematicLoader implements net.thehunter365.spectroworldapi.shem.SchematicLoader {


    @Override
    public AbstractSchematic createSchematic(AbstractLocation block, AbstractLocation block2) {
        int minX, minZ, minY;
        int maxX, maxZ, maxY;

        minX = block.getX() < block2.getX() ? block.getX() : block2.getX();
        minZ = block.getZ() < block2.getZ() ? block.getZ() : block2.getZ();
        minY = block.getY() < block2.getY() ? block.getY() : block2.getY();

        maxX = block.getX() > block2.getX() ? block.getX() : block2.getX();
        maxZ = block.getZ() > block2.getZ() ? block.getZ() : block2.getZ();
        maxY = block.getY() > block2.getY() ? block.getY() : block2.getY();

        int xSize = maxX-minX+1;
        int ySize = maxY-minY+1;
        int zSize = maxZ-minZ+1;

        Schematic schematic = new Schematic(xSize, ySize, zSize, new SchematicBlock[xSize][ySize][zSize]);
        World world = Bukkit.getWorld(block.getWorldId());
        for(int x = minX; x <= maxX; x++){

            for(int y = minY; y <= maxY; y++){

                for(int z = minZ; z <= maxZ; z++){

                    Block b = this.getBlockAt(world, x, y, z);
                    schematic.getBlocks().getBlocksArray()[x-minX][y-minY][z-minZ] = new SchematicBlock(b);
                }
            }
        }
        return schematic;
    }

    @Override
    public void printSchematic(AbstractLocation location, AbstractSchematic schematic) {
        AbstractBlock[][][] array = schematic.getBlocks().getBlocksArray();
        World world = Bukkit.getWorld(location.getWorldId());
        for(int x = 0; x < array.length; x++){
            for(int y = 0; y < array[x].length; y++){
                for(int z = 0; z < array[x][y].length; z++){
                    Location neww = new Location(
                            world,
                            (double)location.getX(),
                            (double)location.getY(),
                            (double) location.getZ()
                    ).clone();
                    neww.add(x, y, z);
                    Block b = neww.getBlock();
                    String name = array[x][y][z].getMaterial();
                    byte data = array[x][y][z].getData();
                    if(!name.equals(Material.AIR.name())) {
                        b.setType(Material.getMaterial(name));
                        b.setData(data);
                        b.getState().update(true);
                    }
                }
            }
        }
    }

    private Block getBlockAt(World world, int x, int y, int z) {
        return world.getBlockAt(x, y, z);
    }
}
