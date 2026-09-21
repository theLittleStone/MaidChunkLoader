package io.github.thelittlestone.maid_chunk_loader.tickets;

import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import io.github.thelittlestone.maid_chunk_loader.MaidChunkLoaderMod;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityLeaveLevelEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MaidChunkLoaderMod.MOD_ID)
public class ChunkLoaderEvents {

    @SubscribeEvent
    public static void onLevelLoad(LevelEvent.Load event) {
        if (event.getLevel() instanceof ServerLevel level) {
            renewAll(level);
        }
    }

    @SubscribeEvent
    public static void onLevelTick(TickEvent.LevelTickEvent event) {
        if (event.side.isClient() || event.phase != TickEvent.Phase.END) {
            return;
        }
        if (event.level instanceof ServerLevel level && level.getGameTime() % 20 == 0) {
            renewAll(level);
        }
    }

    @SubscribeEvent
    public static void onEntityLeave(EntityLeaveLevelEvent event) {
        if (event.getLevel().isClientSide() || !(event.getEntity() instanceof EntityMaid maid)) {
            return;
        }
        Entity.RemovalReason reason = maid.getRemovalReason();
        // Keep the roster when the maid is only written back into an unloaded chunk.
        if (reason != null && reason != Entity.RemovalReason.UNLOADED_TO_CHUNK
                && event.getLevel() instanceof ServerLevel level) {
            ChunkLoaderSavedData.get(level).remove(maid.getUUID());
        }
    }

    private static void renewAll(ServerLevel level) {
        ChunkLoaderSavedData.get(level).forEach((id, pos) -> TicketManager.renew(level, pos, id));
    }
}
