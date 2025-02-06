package net.alec.tutorialmod.item;

import net.alec.tutorialmod.TutorialMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
  // telling forge to register the items we make.
  public static final DeferredRegister<Item> ITEMS =
  DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);
// 1sT ITEM
  public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register(
  "alexandrite" , ()-> new Item(new Item.Properties()));
// 2nd
public static final RegistryObject<Item> RAW_ALEXANDRITE = ITEMS.register(
"raw_alexandrite" , ()-> new Item(new Item.Properties()));

  //telling forge, what our deferred register is for.
  public static void register(IEventBus eventBus){
    ITEMS.register(eventBus);
  }

}
