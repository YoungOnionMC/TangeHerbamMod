package tangeherbam.common.EventHandlers;

import gregtech.api.GregTechAPI;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tangeherbam.THValues;
import tangeherbam.api.material.Materials;

@Mod.EventBusSubscriber(modid = THValues.MODID)
public class MaterialEvent {

    @SubscribeEvent
    public static void onMaterialsInit(GregTechAPI.MaterialEvent event) {
        Materials.registerMaterials();


    }
}
