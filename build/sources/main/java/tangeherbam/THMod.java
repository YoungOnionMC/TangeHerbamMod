package tangeherbam;

import codechicken.lib.CodeChickenLib;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import tangeherbam.common.CommonProxy;

@Mod(modid = THValues.MODID, name = "TangeHerbamAddon", version = THValues.VERSION,
        acceptedMinecraftVersions = "[1.12, 1.13)", dependencies = "required:forge@[14.23.5.2847,);" + CodeChickenLib.MOD_VERSION_DEP + "after:forestry;after:jei@[4.15.0,);after:crafttweaker;before:ctm")

public class THMod {
    @Mod.Instance("TangeHerbamAddon")
    public static THMod instance;

    @SidedProxy(modId = "tangeherbamaddon", clientSide = "tangeherbam.client.ClientProxy", serverSide = "tangeherbam.common.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void onConstruction(FMLConstructionEvent event) {

    }
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        //proxy.init(event);

    }
}
