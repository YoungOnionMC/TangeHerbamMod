package tangeherbam.api.material;


import static gregtech.api.unification.material.Materials.*;
import static net.dries007.tfc.api.types.Metal.Tier.TIER_I;

import gregtech.api.unification.crafttweaker.CTMaterialBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Material.Builder;
import net.dries007.tfc.api.registries.TFCRegistryEvent;
import net.dries007.tfc.api.types.Metal;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tangeherbam.THValues;

public class Materials {

    // Ores/Minerals
    public static Material Argentite;
    public static Material Polybasite;
    public static Material Proustite;

    public static void registerMaterials() {
        Argentite = new Material.Builder(25600, "argentite")
                .gem().ore()
                .color(0x5e5c59)
                .components(Silver, 2, Sulfur, 1)
                .build();
        Polybasite = new Material.Builder(25601, "polybasite")
                .gem()
                .color(0xE0115F)
                .components(Silver, 6, Copper, 6, Stibnite, 2, Arsenic, 2, Sulfur, 7, Silver, 9, Copper, 1, Sulfur, 4)
                .build();
        Proustite = new Material.Builder(25602, "proustite")
                .gem()
                .color(0x997570)
                .components(Silver, 3, Arsenic, 1, Sulfur, 3).build();
    }


    public static final ResourceLocation MERCURY = new ResourceLocation(THValues.MODID, "mercury");
    @SubscribeEvent
    public static void registerGTMetalsAsTFCMetals(TFCRegistryEvent.RegisterPreBlock<Metal> event) {
        event.getRegistry().registerAll(
                new Metal(MERCURY, TIER_I, false, .14f, 580, 0xffffffff, null, null)

        );
    }




}
