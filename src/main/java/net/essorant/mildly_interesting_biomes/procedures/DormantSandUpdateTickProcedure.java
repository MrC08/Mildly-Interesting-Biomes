package net.essorant.mildly_interesting_biomes.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import net.essorant.mildly_interesting_biomes.init.MildlyInterestingBiomesModBlocks;

public class DormantSandUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.AIR) {
			if (world instanceof Level _level)
				_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
		} else {
			if (world.getLevelData().isRaining() && Math.random() < 0.25) {
				world.setBlock(BlockPos.containing(x, y, z), MildlyInterestingBiomesModBlocks.BLOOMING_SAND.get().defaultBlockState(), 3);
			}
		}
	}
}
