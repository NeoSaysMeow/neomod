package net.neo.neomod;

import net.fabricmc.api.ModInitializer;
import net.neo.neomod.block.ModBlocks;
import net.neo.neomod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NeoMod implements ModInitializer {
	public static final String MOD_ID = "neomod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
