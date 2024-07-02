package net.essorant.mildly_interesting_biomes.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.essorant.mildly_interesting_biomes.init.MildlyInterestingBiomesModBlocks;

public class DormantSandUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.getLevelData().isRaining() && Math.random() < 0.1) {
			world.setBlock(BlockPos.containing(x, y, z), MildlyInterestingBiomesModBlocks.BLOOMING_SAND.get().defaultBlockState(), 3);
		}
	}
}
