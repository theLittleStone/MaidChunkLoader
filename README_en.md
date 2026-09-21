# Maid Chunk Loader

[中文](README.md) | [English](README_en.md)

A Forge 1.20.1 mod: after a Touhou Little Maid equips the Chunk Loading Bauble, chunks around her stay loaded.

This repository is a 1.20 port of [MaidChunkLoader-1.21](https://github.com/Dave-12138/MaidChunkLoader).

- Minecraft **1.20.1** / Forge **47.4.0**
- Depends on [Touhou Little Maid](https://www.curseforge.com/minecraft/mc-mods/touhou-little-maid) **≥ 1.5.3**

## Introduction

This mod adds a maid bauble, the Chunk Loading Bauble. A maid wearing it keeps nearby chunks loaded.

## Crafting

Craft the bauble at the **maid altar**:

- Ender Pearl ×1
- Iron Bars ×3
- Costs 0.9 P power

Place the result in the maid’s bauble slot to activate it.

## Behavior

- Chunk tickets refresh about once per second and follow the maid’s current chunk
- After the bauble is removed, tickets last about 15 more seconds
- The roster is saved with the world; on rejoin, tickets are reapplied at the last position, so you do not need to walk up to the maid
- Good news: after quitting and re-entering a save, the maid can still activate and load chunks as expected

Also, while chunk loading is active, random ticks keep running in the maid’s own chunk (that chunk only). Treat it as a feature.

## Config

Loading range is controlled by `load_radius` in `config/maid_chunk_loader-common.toml`.

**`load_radius` is the Chebyshev radius of strongly loaded (entity-ticking) chunks.** The weakly loaded radius is this value plus two.

Default **2**:

| Type | Area |
| --- | --- |
| Strong load (entity ticking) | **5×5** |
| Block ticking | 7×7 |
| Weak load (outer ring) | **9×9** |

Size on a side = `2 * radius + 1`. For example, `4` gives 9×9 strong load and 13×13 weak load.

## License

[MIT](LICENSE)
