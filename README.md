# Maid Chunk Loader


Forge 1.20.1 模组：给车万女仆装备「区块加载饰品」后，女仆周围的区块会保持加载。

本仓库是 [MaidChunkLoader-1.21](https://github.com/Dave-12138/MaidChunkLoader) 的1.20移植版本

- Minecraft **1.20.1** / Forge **47.4.0**
- 依赖：[Touhou Little Maid](https://www.curseforge.com/minecraft/mc-mods/touhou-little-maid) **≥ 1.5.3**


## 介绍

本 Mod 添加了一个女仆饰品“区块加载饰品”，携带该饰品的女仆会加载周围区块。

该效果不“抗卸载”——如果你在远离女仆的地方关闭存档，重新进入时女仆所在区块不会被立即加载。

## 合成

使用 **女仆祭坛** 合成区块加载饰品：

- 末影珍珠 ×1
- 铁栏杆 ×3
- 消耗 0.9 点 P 力

产物放入女仆饰品栏后生效。

## 行为

- 大约每秒刷新一次区块票，跟随女仆所在 chunk
- 卸下饰品后，票大约再保留 15 秒
- **如果女仆自身所在区块已经被卸载，饰品不会工作**

加载半径由配置项 `load_radius` 控制（默认 8），文件：

`config/maid_chunk_loader-common.toml`

该选项包含了弱加载半径，强加载半径在此基础上要减2

此外，在区块加载生效时，女仆所在的区块内会保持随机刻刷新（仅此一个区块），可以看作是某种feature
