package cn.dave12138.maid_chunk_loader.maid;

import cn.dave12138.maid_chunk_loader.items.ItemReg;
import com.github.tartaricacid.touhoulittlemaid.api.ILittleMaid;
import com.github.tartaricacid.touhoulittlemaid.api.LittleMaidExtension;
import com.github.tartaricacid.touhoulittlemaid.item.bauble.BaubleManager;

@LittleMaidExtension
public class MaidExtension implements ILittleMaid {
    @Override
    public void bindMaidBauble(BaubleManager manager) {
        manager.bind(ItemReg.MAID_CHUNK_LOADER_ITEM.get(), ItemReg.MAID_CHUNK_LOADER_ITEM.get());
    }
}
