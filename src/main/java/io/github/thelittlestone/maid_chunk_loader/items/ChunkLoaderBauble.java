package io.github.thelittlestone.maid_chunk_loader.items;

import com.github.tartaricacid.touhoulittlemaid.api.bauble.IMaidBauble;
import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import io.github.thelittlestone.maid_chunk_loader.tickets.ChunkLoaderSavedData;
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
    public void onPutOn(EntityMaid maid, ItemStack baubleItem) {
        remember(maid);
    }

    @Override
    public void onTakeOff(EntityMaid maid, ItemStack baubleItem) {
        if (maid.level() instanceof ServerLevel level) {
            ChunkLoaderSavedData.get(level).remove(maid.getUUID());
        }
    }

    @Override
    public void onTick(EntityMaid maid, ItemStack baubleItem) {
        if (maid.tickCount % 20 == 0) {
            remember(maid);
        }
    }

    private static void remember(EntityMaid maid) {
        if (maid.level() instanceof ServerLevel level) {
            ChunkLoaderSavedData.get(level).put(maid.getUUID(), maid.chunkPosition());
        }
    }
}
