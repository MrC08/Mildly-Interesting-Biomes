
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.essorant.mildly_interesting_biomes.init;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.essorant.mildly_interesting_biomes.MildlyInterestingBiomesMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MildlyInterestingBiomesModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MildlyInterestingBiomesMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {

		if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(MildlyInterestingBiomesModBlocks.BLOOMING_SAND.get().asItem());
			tabData.accept(MildlyInterestingBiomesModBlocks.DORMANT_SAND.get().asItem());
		}
	}
}
