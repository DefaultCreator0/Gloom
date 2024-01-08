package com.defalt.gloom.item;

import com.defalt.gloom.Gloom;
import com.defalt.gloom.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup Gloom_Group = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Gloom.ModID, "gloom"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.gloom"))
                    .icon(()-> new ItemStack(ModBlocks.Gloom_Block)).entries((displayContext, entries) ->
                    {
                        entries.add(ModItems.Gloom_Whisp);
                        entries.add(ModBlocks.Gloom_Block);
                    }).build());

    public static void registerItemGroups(){
        Gloom.LOGGER.info("Registering Item Group for "+Gloom.ModID);
    }
}
