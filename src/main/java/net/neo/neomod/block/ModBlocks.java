package net.neo.neomod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.neo.neomod.NeoMod;
import net.neo.neomod.item.ModItemGroup;

public class ModBlocks {
    public static final Block CRYSTAL_ORE = registerBlock("crystal_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).luminance(5).strength(3).requiresTool(),
                UniformIntProvider.create(2,5)),ModItemGroup.NEOITEMS);
    public static final Block DEEPSLATE_CRYSTAL_ORE = registerBlock("deepslate_crystal_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).luminance(5).requiresTool(),
                    UniformIntProvider.create(2,5)),ModItemGroup.NEOITEMS);


    private static Block registerBlock(String name, Block block, ItemGroup tab){
        registerBlockItem(name,block,tab);
        return Registry.register(Registry.BLOCK,new Identifier(NeoMod.MOD_ID,name),block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab){
        return Registry.register(Registry.ITEM, new Identifier(NeoMod.MOD_ID, name),
                new BlockItem(block,new FabricItemSettings().group(tab)));
    }


    public static void registerModBlocks(){
        NeoMod.LOGGER.debug("Registering ModBlocks for "+NeoMod.MOD_ID);
    }
}
