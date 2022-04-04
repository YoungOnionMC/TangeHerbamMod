package java.tangeherbam;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.tangeherbam.common.CommonProxy;

public class THMod {
    @Mod.Instance("TangeHerbamAddon")
    public static THMod instance;

    @SidedProxy(modId = "tangeherbam", clientSide = "tangeherbam.client.ClientProxy", serverSide = "tangeherbam.common.CommonProxy")
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
