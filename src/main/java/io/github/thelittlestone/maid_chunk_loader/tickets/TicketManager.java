package io.github.thelittlestone.maid_chunk_loader.tickets;

import io.github.thelittlestone.maid_chunk_loader.Config;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.TicketType;
import net.minecraft.world.level.ChunkPos;

import java.util.UUID;

public class TicketManager {
    /** 300-tick timeout; same type+key refresh resets createdTick. */
    private static final TicketType<UUID> MAID_TICKET =
            TicketType.create("maid_chunk_loader", UUID::compareTo, 300);

    public static void renew(ServerLevel level, ChunkPos pos, UUID maidId) {
        level.getChunkSource().addRegionTicket(
                MAID_TICKET, pos, Config.getTicketRadius(), maidId, true);
    }
}
