package net.neo.neomod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.neo.neomod.NeoMod;

public class ModItemGroup {
    public static final ItemGroup NEOITEMS = FabricItemGroupBuilder.build(
            new Identifier(NeoMod.MOD_ID,"neo_items"),() -> new ItemStack(ModItems.PURE_CRYSTAL));
}
