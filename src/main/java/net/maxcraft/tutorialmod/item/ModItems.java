package net.maxcraft.tutorialmod.item;

import net.maxcraft.tutorialmod.TutorialMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;


public class ModItems {


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of);
    }

    public static void registerModItems(){
        TutorialMod.LOGGER.info("Resgistrando Items de Mod para " + TutorialMod.MOD_ID);
    }
}
