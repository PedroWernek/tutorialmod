package net.maxcraft.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.maxcraft.tutorialmod.block.ModBlocks;
import net.maxcraft.tutorialmod.item.ModFuelItems;
import net.maxcraft.tutorialmod.item.ModItemGroups;
import net.maxcraft.tutorialmod.item.ModItems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();

		ModBlocks.registerBlocks();

		ModFuelItems.registerFuelItems();
		
	}
}
