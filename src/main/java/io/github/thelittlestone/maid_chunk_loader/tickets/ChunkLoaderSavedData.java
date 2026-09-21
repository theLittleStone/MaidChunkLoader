package io.github.thelittlestone.maid_chunk_loader.tickets;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.saveddata.SavedData;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiConsumer;

public class ChunkLoaderSavedData extends SavedData {
    public static final String ID = "maid_chunk_loader";

    private final Map<UUID, ChunkPos> entries = new LinkedHashMap<>();

    public static ChunkLoaderSavedData get(ServerLevel level) {
        return level.getDataStorage().computeIfAbsent(
                ChunkLoaderSavedData::load, ChunkLoaderSavedData::new, ID);
    }

    public void put(UUID id, ChunkPos pos) {
        ChunkPos previous = entries.put(id, pos);
        if (!pos.equals(previous)) {
            setDirty();
        }
    }

    public void remove(UUID id) {
        if (entries.remove(id) != null) {
            setDirty();
        }
    }

    public void forEach(BiConsumer<UUID, ChunkPos> consumer) {
        for (Map.Entry<UUID, ChunkPos> entry : entries.entrySet()) {
            consumer.accept(entry.getKey(), entry.getValue());
        }
    }

    public static ChunkLoaderSavedData load(CompoundTag tag) {
        ChunkLoaderSavedData data = new ChunkLoaderSavedData();
        ListTag list = tag.getList("Entries", Tag.TAG_COMPOUND);
        for (int i = 0; i < list.size(); i++) {
            CompoundTag item = list.getCompound(i);
            if (!item.hasUUID("UUID")) {
                continue;
            }
            data.entries.put(item.getUUID("UUID"), new ChunkPos(item.getInt("X"), item.getInt("Z")));
        }
        return data;
    }

    @Override
    public CompoundTag save(CompoundTag tag) {
        ListTag list = new ListTag();
        for (Map.Entry<UUID, ChunkPos> entry : entries.entrySet()) {
            CompoundTag item = new CompoundTag();
            item.putUUID("UUID", entry.getKey());
            item.putInt("X", entry.getValue().x);
            item.putInt("Z", entry.getValue().z);
            list.add(item);
        }
        tag.put("Entries", list);
        return tag;
    }
}
