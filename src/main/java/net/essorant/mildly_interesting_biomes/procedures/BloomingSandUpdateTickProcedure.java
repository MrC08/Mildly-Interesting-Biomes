package net.essorant.mildly_interesting_biomes.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.essorant.mildly_interesting_biomes.init.MildlyInterestingBiomesModBlocks;

public class BloomingSandUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		BlockState blockstate_ = Blocks.AIR.defaultBlockState();
		blockstate_ = (world.getBlockState(BlockPos.containing(x, y, z)));
		if (world.getLevelData().isRaining()) {
			if ((blockstate_.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip2 ? blockstate_.getValue(_getip2) : -1) < 3) {
				{
					int _value = (int) Math.min(3, (blockstate_.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip3 ? blockstate_.getValue(_getip3) : -1) + 1 + Math.random());
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fillbiome ~ ~-2 ~ ~ ~10 ~ mildly_interesting_biomes:blooming_desert replace mildly_interesting_biomes:dormant_desert");
				if (Math.random() < 0.15) {
					for (Direction directioniterator : Direction.values()) {
						if (MildlyInterestingBiomesModBlocks.BLOOMING_SAND.get() == (world.getBlockState(BlockPos.containing(x + directioniterator.getStepX(), y + directioniterator.getStepY(), z + directioniterator.getStepZ()))).getBlock()) {
							BloomingSandUpdateTickProcedure.execute(world, (x + directioniterator.getStepX()), (y + directioniterator.getStepY()), (z + directioniterator.getStepZ()), blockstate);
						}
					}
				}
			}
		} else {
			if ((blockstate_.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip21 ? blockstate_.getValue(_getip21) : -1) > 0) {
				{
					int _value = (int) ((blockstate_.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip22 ? blockstate_.getValue(_getip22) : -1) - 1);
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
			} else {
				world.setBlock(BlockPos.containing(x, y, z), MildlyInterestingBiomesModBlocks.DORMANT_SAND.get().defaultBlockState(), 3);
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fillbiome ~ ~-2 ~ ~ ~10 ~ mildly_interesting_biomes:dormant_desert replace mildly_interesting_biomes:blooming_desert");
			}
		}
	}
}
