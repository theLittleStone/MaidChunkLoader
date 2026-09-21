package cn.dave12138.maid_chunk_loader.items;

import cn.dave12138.maid_chunk_loader.MaidChunkLoaderMod;
import com.github.tartaricacid.touhoulittlemaid.init.InitCreativeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = MaidChunkLoaderMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemReg {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MaidChunkLoaderMod.MOD_ID);

    public static final RegistryObject<ChunkLoaderBauble> MAID_CHUNK_LOADER_ITEM =
            ITEMS.register("maid_chunk_loader_bauble", ChunkLoaderBauble::new);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    @SubscribeEvent
    public static void registerCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == InitCreativeTabs.MAIN_TAB.get()) {
            event.accept(MAID_CHUNK_LOADER_ITEM.get());
        }
    }
}
