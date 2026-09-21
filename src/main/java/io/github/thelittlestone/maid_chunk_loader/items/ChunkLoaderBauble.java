package io.github.thelittlestone.maid_chunk_loader.items;

import io.github.thelittlestone.maid_chunk_loader.Config;
import io.github.thelittlestone.maid_chunk_loader.tickets.TicketManager;
import com.github.tartaricacid.touhoulittlemaid.api.bauble.IMaidBauble;
import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ChunkLoaderBauble extends Item implements IMaidBauble {

    public ChunkLoaderBauble() {
        super(new Item.Properties());
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        tooltip.add(Component.translatable("tooltip.maid_chunk_loader.maid_chunk_loader_bauble.desc")
                .withStyle(ChatFormatting.GRAY));
    }

    @Override
    public void onTick(EntityMaid maid, ItemStack baubleItem) {
        // Ticket lifespan is 300 ticks; refresh every second so the load area follows the maid.
        if (maid.level() instanceof ServerLevel serverLevel && maid.tickCount % 20 == 0) {
            serverLevel.getChunkSource().addRegionTicket(
                    TicketManager.getMaidTicket(),
                    maid.chunkPosition(),
                    Config.getRadius(),
                    maid,
                    true
            );
        }
    }
}
