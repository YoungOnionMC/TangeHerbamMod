package tangeherbam.common;

import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import tangeherbam.THValues;

@Mod.EventBusSubscriber(modid = THValues.MODID)
public class CommonProxy {
    public void preInit() {

    }

    @SubscribeEvent()
    public static void init(RegistryEvent.Register<IRecipe> event) {

    }

}
