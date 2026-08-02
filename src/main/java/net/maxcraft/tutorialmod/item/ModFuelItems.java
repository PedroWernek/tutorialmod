package net.maxcraft.tutorialmod.item;

import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModFuelItems {
    public static void registerFuelItems(){
        FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 200000);
    }
}
