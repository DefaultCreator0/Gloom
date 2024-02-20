package com.defalt.gloom.block.custom;

import com.defalt.gloom.Gloom;
import com.defalt.gloom.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.stream.Stream;

public class Sky_Arch_Frame_Block extends Block {

    public static final IntProperty Level = IntProperty.of("level",0,5);

    public Sky_Arch_Frame_Block(Settings settings) {
        super(settings);
    }

    private static VoxelShape Shape0 = Stream.of(
            Block.createCuboidShape(5, 13, 5, 11, 16, 11),
            Block.createCuboidShape(7, 0, 7, 9, 6, 9),
            Block.createCuboidShape(6, 6, 6, 10, 13, 10)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static VoxelShape Shape1 = VoxelShapes.combineAndSimplify(
            Block.createCuboidShape(5, 6, 5, 12, 16, 12),
            Block.createCuboidShape(5, 0, 5, 11, 6, 11),
            BooleanBiFunction.OR);

    private static VoxelShape Shape2 = VoxelShapes.combineAndSimplify(
            Block.createCuboidShape(3, 0, 3, 13, 9, 13),
            Block.createCuboidShape(2, 9, 2, 14, 16, 14),
            BooleanBiFunction.OR);

    private static VoxelShape Shape3 = VoxelShapes.combineAndSimplify(
            Block.createCuboidShape(2, 0, 2, 14, 4, 14),
            Block.createCuboidShape(1, 4, 1, 15, 16, 15),
            BooleanBiFunction.OR);

    private static VoxelShape Shape4 = Block.createCuboidShape(1, 0, 1, 15, 16, 15);

    private static VoxelShape Shape5 = Block.createCuboidShape(0, 0, 0, 16, 16, 16);


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        String condition = world.getBlockState(pos.down()).toString();
        //Shape is determined by the blockstate below it
        if(condition.contains("0")){return Shape1;}
        if(condition.contains("1")){return Shape2;}
        if(condition.contains("2")){return Shape3;}
        if(condition.contains("3")){return Shape4;}
        if(condition.contains("4")){return Shape5;}
        if(condition.contains("5")){return Shape0;}
        //Default shape if nothing is chosen
        return Shape0;
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);

        BlockState blockstate = world.getBlockState(pos.down());
        //Places blockstate 0 if the block underneath isn't an arch block
        if(!blockstate.isOf(ModBlocks.Sky_Arch_Frame_Block)){world.setBlockState(pos,state.with(Level,0));}
        if(blockstate.isOf(ModBlocks.Sky_Arch_Frame_Block)){
            String condition = world.getBlockState(pos.down()).toString();
            //Changing the block states depending on the height of the arch pillar
            if(condition.contains("0")){world.setBlockState(pos,state.with(Level,1));}
            if(condition.contains("1")){world.setBlockState(pos,state.with(Level,2));}
            if(condition.contains("2")){world.setBlockState(pos,state.with(Level,3));}
            if(condition.contains("3")){world.setBlockState(pos,state.with(Level,4));}
            if(condition.contains("4")){world.setBlockState(pos,state.with(Level,5));}
            if(condition.contains("5")){world.setBlockState(pos,state.with(Level,0));}
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Level);
    }
}
