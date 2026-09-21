package io.github.thelittlestone.maid_chunk_loader;

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
        LOAD_RADIUS = BUILDER.comment(
                "Chebyshev radius of STRONG (entity-ticking) chunks, not the weakly loaded outer ring.",
                "Internal vanilla ticket radius is load_radius + 2.",
                "Default 2 = 5x5 strong, 7x7 block-tick, 9x9 weakly loaded."
        ).defineInRange("load_radius", 2, 0, 64);
        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    private static int radius = 2;

    /** Strong-load Chebyshev radius from config. */
    public static int getRadius() {
        return radius;
    }

    /** Vanilla addRegionTicket radius: strong ring plus the weak outer fringe. */
    public static int getTicketRadius() {
        return radius + 2;
    }

    private static void renewConfig() {
        radius = LOAD_RADIUS.get();
    }

    @SubscribeEvent
    public static void onLoad(ModConfigEvent event) {
        renewConfig();
    }
}
