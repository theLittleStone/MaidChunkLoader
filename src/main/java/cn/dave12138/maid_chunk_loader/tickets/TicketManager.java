package cn.dave12138.maid_chunk_loader.tickets;

import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import net.minecraft.server.level.TicketType;
import net.minecraft.world.entity.Entity;

import java.util.Comparator;

public class TicketManager {
    private static final Comparator<EntityMaid> CP = Comparator.comparing(Entity::getUUID);
    private static final TicketType<EntityMaid> maidTicket = TicketType.create("maid", CP, 300);

    public static TicketType<EntityMaid> getMaidTicket() {
        return maidTicket;
    }
}
