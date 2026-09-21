package cn.dave12138.maid_chunk_loader;

import cn.dave12138.maid_chunk_loader.items.ItemReg;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MaidChunkLoaderMod.MOD_ID)
public class MaidChunkLoaderMod {
    public static final String MOD_ID = "maid_chunk_loader";

    public MaidChunkLoaderMod(FMLJavaModLoadingContext context) {
        IEventBus modBus = context.getModEventBus();
        ItemReg.register(modBus);
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
