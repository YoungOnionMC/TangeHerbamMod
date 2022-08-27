package tangeherbam.common.metaitem;

import net.dries007.tfc.api.capability.size.Size;
import net.dries007.tfc.api.capability.size.Weight;
import net.dries007.tfc.objects.items.ItemMisc;

import javax.annotation.Nullable;

public class THItem extends ItemMisc {

    private final String oreDictionary;

    public THItem(Size size, Weight weight, String oreDictionary) {
        super(size, weight);
        this.oreDictionary = oreDictionary;
    }

    public THItem(Size size, Weight weight) {
        super(size, weight);
        this.oreDictionary = null;
    }

    @Nullable
    public String getOreDictionary() {
        return oreDictionary;
    }

}
