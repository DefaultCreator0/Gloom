package com.defalt.gloom.item;

import com.defalt.gloom.Gloom;
import com.defalt.gloom.item.custom.gloom_whisp;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item Gloom_Whisp = registerItem("gloom_whisp",new gloom_whisp(new FabricItemSettings()));
    public static final Item Sundelion = registerItem("sundelion", new Item(new FabricItemSettings()));
    public static final Item Sundelion_Petal = registerItem("sundelion_petal", new Item(new FabricItemSettings()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(Gloom_Whisp);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Gloom.ModID,name),item);
    }

    public static void registerModItems(){
        Gloom.LOGGER.info("Registering Items for " +Gloom.ModID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);

    }

}
