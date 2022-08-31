package tangeherbam.common.EventHandlers;

import net.dries007.tfc.api.capability.heat.CapabilityItemHeat;
import net.dries007.tfc.api.capability.heat.IItemHeat;
import net.dries007.tfc.util.Helpers;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tangeherbam.THValues;

import java.util.List;

@Mod.EventBusSubscriber(modid = THValues.MODID)
public class TooltipEvent {

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void GTMetalTooltips(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        Item item = stack.getItem();
        List<String> tt = event.getToolTip();
        if(!stack.isEmpty()) {
//            if(event.getFlags().isAdvanced()) {
//                IItemHeat heatInfo = stack.getCapability(CapabilityItemHeat.ITEM_HEAT_CAPABILITY, null);
//                if(heatInfo != null) {
//                    tt.add("");
//                    tt.add(I18n.format("tfc.tooltip.metal", I18n.format(Helpers.getTypeName(metal))));
//                    tt.add(I18n.format("tfc.tooltip.units", heatInfo.(stack)));
//                    tt.add(I18n.format("tfc.tooltip.melttemp", melttemp));
//                    tt.add(I18n.format(Helpers.getEnumName(metal.getTier())));
//                }
//            }
        }
    }
}
