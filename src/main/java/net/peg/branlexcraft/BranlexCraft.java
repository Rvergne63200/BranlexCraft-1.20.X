package net.peg.branlexcraft;

import net.fabricmc.api.ModInitializer;

import net.peg.branlexcraft.item.ModItemGroups;
import net.peg.branlexcraft.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BranlexCraft implements ModInitializer {
	public static final String MOD_ID = "branlexcraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();

	}
}