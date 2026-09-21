# Maid Chunk Loader

Forge 1.20.1 模组：给车万女仆装备「区块加载饰品」后，女仆周围的区块会保持加载。

本仓库是 [MaidChunkLoader-1.21](https://github.com/Dave-12138/MaidChunkLoader) 的1.20移植版本

- Minecraft **1.20.1** / Forge **47.4.0**
- 依赖：[Touhou Little Maid](https://www.curseforge.com/minecraft/mc-mods/touhou-little-maid) **≥ 1.5.3**

## 介绍

本 Mod 添加了一个女仆饰品“区块加载饰品”，携带该饰品的女仆会加载周围区块。

## 合成

使用 **女仆祭坛** 合成区块加载饰品：

- 末影珍珠 ×1
- 铁栏杆 ×3
- 消耗 0.9 点 P 力

产物放入女仆饰品栏后生效。

## 行为

- 大约每秒刷新一次区块票，跟随女仆所在 chunk
- 卸下饰品后，票大约再保留 15 秒
- 名单会写入世界存档；重进游戏时会按最后位置重新打票，不必走近女仆
- 喜报：现在退出存档重进后女仆依然能够正常激活并加载区块了

此外，在区块加载生效时，女仆所在的区块内会保持随机刻刷新（仅此一个区块），可以看作是某种 feature

## 配置

加载范围由配置项 `load_radius` 控制，文件位于 `config/maid_chunk_loader-common.toml`

**`load_radius` 是强加载（实体 tick）的切比雪夫半径**，弱加载半径要在此基础之上加二**

默认为 **2**：

| 类型 | 范围 |
| --- | --- |
| 强加载（实体 tick） | **5×5** |
| 方块 tick | 7×7 |
| 弱加载（最外圈） | **9×9** |

换算： 加载范围边长 = `2 * 半径 + 1`。例如改为 `4` 时，强加载 9×9、弱加载 13×13。

## 许可

[MIT](LICENSE)
