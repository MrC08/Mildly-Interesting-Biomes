
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.essorant.mildly_interesting_biomes.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.essorant.mildly_interesting_biomes.MildlyInterestingBiomesMod;

public class MildlyInterestingBiomesModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MildlyInterestingBiomesMod.MODID);
	public static final RegistryObject<Item> BLOOMING_SAND = block(MildlyInterestingBiomesModBlocks.BLOOMING_SAND);
	public static final RegistryObject<Item> DORMANT_SAND = block(MildlyInterestingBiomesModBlocks.DORMANT_SAND);

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
