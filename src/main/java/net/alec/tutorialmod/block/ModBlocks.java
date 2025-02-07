package net.alec.tutorialmod.block;

import net.alec.tutorialmod.TutorialMod;
import net.alec.tutorialmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
  //telling forge to register the items we make.
  public static final DeferredRegister<Block> BLOCKS =
  DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);
//1st Block
    public static final RegistryObject<Block> ALEXANDRITE_BLOCK = registerBlock(
    "alexandrite_block", ()-> new Block(BlockBehaviour.Properties.of()
    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
//2nd Block
  public static final RegistryObject<Block> RAW_ALEXANDRITE_BLOCK = registerBlock(
  "raw_alexandrite_block",()-> new Block(BlockBehaviour.Properties.of()
.strength(4f).sound(SoundType.COPPER)));
//3rd Block


///Preparation For adding blocks
/// Custom method for automating block creation
  private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
   RegistryObject<T> toReturn = BLOCKS.register(name, block);
   registerBlockItem(name, toReturn);
   return toReturn;
  }
/// Custom method for automating block item creation
  private static <T extends  Block> void registerBlockItem(String name, RegistryObject<T> block){
    ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
  }

  public static void register(IEventBus eventBus){
    BLOCKS.register(eventBus);
  }
}
