package com.defalt.gloom.block;

import com.defalt.gloom.Gloom;
import com.defalt.gloom.block.custom.GloomBlock;
import com.defalt.gloom.block.custom.Sundelion_block;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block Gloom_Block = registerBlock("gloom_block",
            new GloomBlock(FabricBlockSettings.copyOf(Blocks.SCULK)));

    public static final Block Sundelion = registerBlock("sundelion",
            new FlowerBlock(StatusEffects.GLOWING, 1,
                    FabricBlockSettings.copyOf(Blocks.CORNFLOWER).nonOpaque().noCollision()));

    public static final Block Potted_Sundelion = registerBlock("potted_sundelion_block",
            new FlowerPotBlock(Sundelion, FabricBlockSettings.copyOf(Blocks.CORNFLOWER).nonOpaque()));

    private static Block registerBlock(String name,Block block){
        registerBlockItem(name,block);



        return Registry.register(Registries.BLOCK, new Identifier(Gloom.ModID, name),block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(Gloom.ModID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        Gloom.LOGGER.info("Registering Blocks for " +Gloom.ModID);
    }




}
