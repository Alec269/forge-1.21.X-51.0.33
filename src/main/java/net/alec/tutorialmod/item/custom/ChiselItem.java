package net.alec.tutorialmod.item.custom;

import net.alec.tutorialmod.block.ModBlocks;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class ChiselItem extends Item {
  private static final Map<Block, Block> CHISEL_MAP =
  Map.of(
        Blocks.STONE ,Blocks.STONE_BRICKS,
        Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
        Blocks.GRANITE, Blocks.POLISHED_GRANITE,
        Blocks.ANCIENT_DEBRIS, ModBlocks.ALEXANDRITE_BLOCK.get(),
        Blocks.ANDESITE, Blocks.POLISHED_ANDESITE
  ); //this is a map to use for checking ...
  //constructor for special item
  public ChiselItem(Properties pProperties){ //properties
    super(pProperties);  //tells info to minecraft
  }

@Override //overriding the default mc useOn method
          // Enum ↓       // ↓  Method
  public InteractionResult useOn(UseOnContext pContext) {
    Level level = pContext.getLevel();
    Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

    // Functionality of Item
   if (CHISEL_MAP.containsKey(clickedBlock)){
     if(!level.isClientSide()){      //if not clientside then
       level.setBlockAndUpdate(pContext.getClickedPos(),  //change
       CHISEL_MAP.get(clickedBlock).defaultBlockState());// block

       //Damage the item on use --------
       pContext.getItemInHand().hurtAndBreak(1,((ServerLevel) level),
          ((ServerPlayer) pContext.getPlayer()),
       item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

       //play a sound ------
       level.playSound(null, pContext.getClickedPos(), SoundEvents.GRINDSTONE_USE,
       SoundSource.BLOCKS);
     }
    }

    return InteractionResult.SUCCESS;
  }
}
