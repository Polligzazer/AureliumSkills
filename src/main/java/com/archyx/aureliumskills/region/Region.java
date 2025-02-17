package com.archyx.aureliumskills.region;

import org.bukkit.World;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Region {

    private final World world;
    private final int x;
    private final int z;
    private final ConcurrentMap<ChunkCoordinate, ChunkData> chunks;
    private boolean reload;

    public Region(World world, int x, int z) {
        this.world = world;
        this.x = x;
        this.z = z;
        this.chunks = new ConcurrentHashMap<>();
        this.reload = false;
    }

    public World getWorld() {
        return world;
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }

    @Nullable
    public ChunkData getChunkData(ChunkCoordinate chunkCoordinate) {
        return chunks.get(chunkCoordinate);
    }

    public void setChunkData(ChunkCoordinate chunkCoordinate, ChunkData chunkData) {
        chunks.put(chunkCoordinate, chunkData);
    }

    public Map<ChunkCoordinate, ChunkData> getChunkMap() {
        return chunks;
    }

    public void setReload(boolean reload) {
        this.reload = reload;
    }

    public boolean shouldReload() {
        return reload;
    }

}
