package net.neo.neomod.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;

public class Crystals {
    public static final Crystal PIG = Crystals.register("pig",new Crystal("pig",EntityType.PIG));



    private static Crystal register(String name, Crystal type) {
        return Registry.register(ModRegistry.CRYSTAL, name, type);
    }
}
