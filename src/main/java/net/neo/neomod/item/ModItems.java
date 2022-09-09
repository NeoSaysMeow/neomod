package net.neo.neomod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.MutableRegistry;
import net.minecraft.util.registry.Registry;
import net.neo.neomod.NeoMod;
import net.neo.neomod.item.custom.CrystalItem;
import net.neo.neomod.item.custom.FilledCrystalItem;

public class ModItems {

    public static final Item UNREFINED_CRYSTAL = registerItem("unrefined_crystal",
            new Item(new FabricItemSettings().group(ModItemGroup.NEOITEMS)));
    public static final Item PURE_CRYSTAL = registerItem("crystal",
            new CrystalItem(new FabricItemSettings().group(ModItemGroup.NEOITEMS)));
    public static final Item FILLED_CRYSTAL = registerItem("filled_crystal",
            new FilledCrystalItem(new FabricItemSettings().group(ModItemGroup.NEOITEMS)));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM,new Identifier(NeoMod.MOD_ID,name),item);
    }

    public static void registerModItems() {
        NeoMod.LOGGER.debug("Registering Mod Items for " + NeoMod.MOD_ID);
    }

}
