package tangeherbam.common.EventHandlers;

import gregtech.api.GTValues;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.util.GTUtility;
import gregtech.common.blocks.BlockOre;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentWaterWalker;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tangeherbam.THValues;
import tangeherbam.api.OreDictionaries;

import static net.minecraftforge.fml.common.eventhandler.EventPriority.*;

@Mod.EventBusSubscriber(modid = THValues.MODID)
public class OreEvent {

    @SubscribeEvent(priority = HIGH)
    public static void oreMine(BlockEvent.HarvestDropsEvent event) {
        if(!event.getWorld().isRemote && event.getHarvester() != null && !event.isSilkTouching()) {
            if(event.getState().getBlock() instanceof BlockOre) {
                Material oreMaterial = ((BlockOre)event.getState().getBlock()).material;
                int level = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, event.getHarvester().getHeldItemMainhand());
                event.getDrops().set(0, OreDictUnifier.get(OreDictionaries.LargeChunk, oreMaterial, GTValues.RNG.nextInt(3 + level) + 1));
                if(level > 0)
                    event.getDrops().set(1, OreDictUnifier.get(OreDictionaries.MediumChunk, oreMaterial, GTValues.RNG.nextInt(3)));
                if(level > 1)
                    event.getDrops().set(2, OreDictUnifier.get(OreDictionaries.SmallChunk, oreMaterial, GTValues.RNG.nextInt(5)));
            }
        }
    }

}
