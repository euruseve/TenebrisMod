package net.euruseve.tenebris.custom.items;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class PinkWoolPainter extends Item {
    public PinkWoolPainter(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos pos = pContext.getClickedPos();
        BlockState state = level.getBlockState(pos);

        if (state.is(BlockTags.WOOL) && !state.is(Blocks.PINK_WOOL)) {
            if (!level.isClientSide) {
                level.setBlock(pos, Blocks.PINK_WOOL.defaultBlockState(), Block.UPDATE_ALL);
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }
}
