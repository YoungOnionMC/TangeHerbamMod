package tangeherbam.common.metaitem;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import net.dries007.tfc.api.capability.size.Size;
import net.dries007.tfc.api.capability.size.Weight;
import net.dries007.tfc.objects.CreativeTabsTFC;
import net.dries007.tfc.objects.items.ItemMisc;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;


import static tangeherbam.THValues.MODID;

@Mod.EventBusSubscriber(modid = MODID)
@GameRegistry.ObjectHolder(MODID)
public class THItems {

    @GameRegistry.ObjectHolder("bearing/tin")
    public static final Item TIN_BEARING = null;
    @GameRegistry.ObjectHolder("bearing/rosegold")
    public static final Item ROSE_GOLD_BEARING = null;
    @GameRegistry.ObjectHolder("bearing/steel")
    public static final Item STEEL_BEARING = null;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> r = event.getRegistry();
        ImmutableList.Builder<Item> simpleItems = ImmutableList.builder();

        simpleItems.add(register(r, "bearing/tin", new THItem(Size.TINY, Weight.LIGHT, "bearingTin"), CreativeTabsTFC.CT_METAL));
        simpleItems.add(register(r, "bearing/rosegold", new THItem(Size.TINY, Weight.LIGHT, "bearingRoseGold"), CreativeTabsTFC.CT_METAL));
        simpleItems.add(register(r, "bearing/steel", new THItem(Size.TINY, Weight.LIGHT, "bearingSteel"), CreativeTabsTFC.CT_METAL));
    }

    public static <T extends Item> T register(IForgeRegistry<Item> r, String name, T item, CreativeTabs ct) {
        item.setRegistryName(MODID, name);
        item.setTranslationKey(MODID + "." + name.replace('/', '.'));
        item.setCreativeTab(ct);
        r.register(item);
        return item;
    }
}
