package cn.dave12138.maid_chunk_loader;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = MaidChunkLoaderMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER;

    private static final ForgeConfigSpec.IntValue LOAD_RADIUS;

    static final ForgeConfigSpec SPEC;

    static {
        BUILDER = new ForgeConfigSpec.Builder();
        BUILDER.push("Chunk Loader");
        LOAD_RADIUS = BUILDER.defineInRange("load_radius", 8, 0, 64);
        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    private static int radius = 3;

    public static int getRadius() {
        return radius;
    }

    private static void renewConfig() {
        radius = LOAD_RADIUS.get();
    }

    @SubscribeEvent
    public static void onLoad(ModConfigEvent event) {
        renewConfig();
    }
}
