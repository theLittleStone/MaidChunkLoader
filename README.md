# Maid Chunk Loader

Forge 1.20.1 模组：给车万女仆装备「区块加载饰品」后，女仆周围的区块会保持加载。

- Minecraft **1.20.1** / Forge **47.4.0**
- 硬依赖：[Touhou Little Maid](https://www.curseforge.com/minecraft/mc-mods/touhou-little-maid) **≥ 1.5.3**
- 作者：[theLittleStone](https://github.com/theLittleStone)
- 仓库：https://github.com/theLittleStone/MaidChunkLoader
- 协议：[Unlicense](LICENSE)

## 合成

不是工作台。使用女仆 **祭坛**：

- 末影珍珠 ×1
- 铁栏杆 ×3
- 消耗 0.9 点 P 力

产物放入女仆饰品栏后生效。

## 行为

- 大约每秒刷新一次区块票，跟随女仆所在 chunk
- 卸下饰品后，票大约再保留 15 秒
- **如果女仆自身所在区块被卸载，饰品不会工作**

加载半径由配置项 `load_radius` 控制（默认 8），文件：

`config/maid_chunk_loader-common.toml`

## 开发

需要 **JDK 17**。把 TLM 1.5.3 的 Forge 包放到 `libs/touhoulittlemaid-1.5.3.jar`（版本号里不能有 `+`），然后：

```bat
gradlew.bat build
```

产物：`build/libs/maid_chunk_loader-forge-1.20.1-<version>.jar`

开发客户端：

```bat
gradlew.bat runClient
```
