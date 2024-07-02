
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.essorant.mildly_interesting_biomes.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.essorant.mildly_interesting_biomes.block.DormantSandBlock;
import net.essorant.mildly_interesting_biomes.block.BloomingSandBlock;
import net.essorant.mildly_interesting_biomes.MildlyInterestingBiomesMod;

public class MildlyInterestingBiomesModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MildlyInterestingBiomesMod.MODID);
	public static final RegistryObject<Block> BLOOMING_SAND = REGISTRY.register("blooming_sand", () -> new BloomingSandBlock());
	public static final RegistryObject<Block> DORMANT_SAND = REGISTRY.register("dormant_sand", () -> new DormantSandBlock());
}
