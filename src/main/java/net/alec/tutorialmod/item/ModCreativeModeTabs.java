package net.alec.tutorialmod.item;

import net.alec.tutorialmod.TutorialMod;
import net.alec.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
  DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);
//A creative tab
  public static final RegistryObject<CreativeModeTab> ALEXANDRITE_ITEMS_TABS =
  CREATIVE_MODE_TABS.register("alexandrite_items_tab",
  ()-> CreativeModeTab.builder()
  .icon(()->new ItemStack(ModItems.ALEXANDRITE.get()))
  .title(Component.translatable("creativetab.tutorialmod.alexandrite_item"))
  .displayItems((pParameters, pOutput) -> {
      pOutput.accept(ModItems.ALEXANDRITE.get());
      pOutput.accept(ModItems.RAW_ALEXANDRITE.get());
      pOutput.accept(ModItems.CHISEL.get());
  })
  .build());
//2nd Tab
  public static final RegistryObject<CreativeModeTab> ALEXANDRITE_BLOCKS_TABS =
  CREATIVE_MODE_TABS.register("alexandrite_blocks_tab",
  ()-> CreativeModeTab.builder()
  .withTabsBefore(ALEXANDRITE_ITEMS_TABS.getId()) //to make sure this is the 2nd one
  .icon(()->new ItemStack(ModBlocks.ALEXANDRITE_BLOCK.get()))
  .title(Component.translatable("creativetab.tutorialmod.alexandrite_block"))
  .displayItems((pParameters, pOutput) -> {
    pOutput.accept(ModBlocks.ALEXANDRITE_BLOCK.get());
    pOutput.accept(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());
    pOutput.accept(ModBlocks.ALEXANDRITE_ORE.get());
    pOutput.accept(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get());
  })
  .build());

  public static void register(IEventBus eventBus){
    CREATIVE_MODE_TABS.register(eventBus);
  }
}
