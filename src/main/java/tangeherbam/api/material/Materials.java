package tangeherbam.api.material;


import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.ore.OrePrefix.ingot;
import static net.dries007.tfc.api.types.Metal.Tier.TIER_0;
import static net.dries007.tfc.api.types.Metal.Tier.TIER_I;

import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.crafttweaker.CTMaterialBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Material.Builder;
import gregtech.api.unification.material.info.MaterialFlag;
import gregtech.api.unification.material.properties.OreProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import net.dries007.tfc.api.capability.heat.CapabilityItemHeat;
import net.dries007.tfc.api.capability.heat.IItemHeat;
import net.dries007.tfc.api.capability.heat.ItemHeatHandler;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.registries.TFCRegistryEvent;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tangeherbam.THValues;

import java.util.*;

public class Materials {

    // Material Flags
    public static List<MaterialFlag> STANDARDPLATE = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_PLATE, GENERATE_DENSE, EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES));
    public static List<MaterialFlag> STANDARDWIREFINE = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_FINE_WIRE));
    public static List<MaterialFlag> STANDARDFOIL = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_FOIL));
    public static List<MaterialFlag> STANDARDROD = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_BOLT_SCREW));
    public static List<MaterialFlag> STANDARDROTOR = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_ROTOR, GENERATE_RING));
    public static List<MaterialFlag> STANDARDGEAR = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_GEAR, GENERATE_SMALL_GEAR));
    public static List<MaterialFlag> STANDARDSPRING = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_SPRING, GENERATE_SPRING_SMALL));
    public static List<MaterialFlag> STANDARDROUND = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_ROUND));
    public static List<MaterialFlag> STANDARDLENS = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_LENS));

    public static List<MaterialFlag> STANDARDCASING = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_FRAME));
    public static List<MaterialFlag> STANDARDGEM = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_LENS, HIGH_SIFTER_OUTPUT));

    @SafeVarargs
    public static List<MaterialFlag> SetMaterialFlags(List<MaterialFlag>... materials) {
        List<MaterialFlag> result = new ArrayList<MaterialFlag>();
        for(List<MaterialFlag> x : materials) {
            result.addAll(x);
        }
        return result;
    }

    // Stones
    public static Material Gabbro;
    public static Material Shale;
    public static Material Claystone;
    public static Material LimestoneTFC;
    public static Material Conglomerate;
    public static Material Dolomite;
    public static Material Chert;
    public static Material Chalk;
    public static Material Rhyolite;
    public static Material Dacite;
    public static Material SlateTFC;
    public static Material Phyllite;
    public static Material Schist;
    public static Material Gneiss;

    // Ores/Minerals
    public static Material Argentite;
    public static Material Polybasite;
    public static Material Proustite;

    public static Material LigniteCoal;

    public static Material Titanomagnetite;

    public static void registerMaterials() {
        Gabbro = new Material.Builder(25620, "gabbro")
                .dust()
                .build();
        Shale = new Material.Builder(25621, "shale")
                .dust()
                .build();
        Claystone = new Material.Builder(25622, "claystone")
                .dust()
                .build();
        LimestoneTFC = new Material.Builder(25623, "limestonetfc")
                .dust()
                .build();
        Conglomerate = new Material.Builder(25624, "conglomerate")
                .dust()
                .build();
        Dolomite = new Material.Builder(25625, "dolomite")
                .dust()
                .build();
        Chert = new Material.Builder(25626, "chert")
                .dust()
                .build();
        Chalk = new Material.Builder(25627, "chalk")
                .dust()
                .build();
        Rhyolite = new Material.Builder(25628, "rhyolite")
                .dust()
                .build();
        Dacite = new Material.Builder(25629, "dacite")
                .dust()
                .build();
        SlateTFC = new Material.Builder(25630, "slatetfc")
                .dust()
                .build();
        Phyllite = new Material.Builder(25631, "phyllite")
                .dust()
                .build();
        Schist = new Material.Builder(25632, "schist")
                .dust()
                .build();
        Gneiss = new Material.Builder(25633, "gneiss")
                .dust()
                .build();

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

        Titanomagnetite = new Material.Builder(25705, "titanomagnetite")
                .ore().dust()
                .components(Iron, 1, Iron, 2, Titanium, 2, Oxygen, 4).build();

        Titanomagnetite.setFormula("Fe(FeTi)2O4");

        LigniteCoal = new Material.Builder(25706, "lignite_coal")
                .ore().gem()
                .components(Carbon, 1, Water, 4, Ash, 1).build();



        Gallium.setProperty(PropertyKey.ORE, new OreProperty(1, 1, false));
        Manganese.setProperty(PropertyKey.ORE, new OreProperty(1, 1, false));
        Uranium235.setProperty(PropertyKey.ORE, new OreProperty(1, 1, false));
        Rutile.setProperty(PropertyKey.ORE, new OreProperty(1, 1, false));

        Copper.addFlags(GENERATE_GEAR, GENERATE_SMALL_GEAR);
    }


    public static class GTMetal {
        public Material mat;
        public float specificHeat;
        public float meltingPoint;

        public GTMetal(Material mat, float specificHeat, float melt) {
            this.mat = mat;
            this.specificHeat = specificHeat;
            this.meltingPoint = melt;
        }
    };

    public static Set<GTMetal> gtMetals = new HashSet<>();

    public static void registerGTMetalsAsTFCMetals() {
        gtMetals.add(new GTMetal(WroughtIron, .5f, 1538f));
        gtMetals.add(new GTMetal(Steel, .466f, 1540f));
        gtMetals.add(new GTMetal(Gold, .126f, 1064f));
        gtMetals.add(new GTMetal(StainlessSteel, .5f, 1530));
        //gtMetals.add(new GTMetal(Iron, .35f, 7));
       // gtMetals.add(new GTMetal(Iron, .35f, 7));
        //gtMetals.add(new GTMetal(Iron, .35f, 7));
        //gtMetals.add(new GTMetal(Iron, .35f, 7));
        //gtMetals.add(new GTMetal(Iron, .35f, 7));
        //gtMetals.add(new GTMetal(Iron, .35f, 7));
        //gtMetals.add(new GTMetal(Iron, .35f, 7));

        for(GTMetal metal : gtMetals) {

            CapabilityItemHeat.CUSTOM_ITEMS.put(IIngredient.of(OreDictUnifier.get(ingot, metal.mat)), () -> new ItemHeatHandler(null, metal.specificHeat, metal.meltingPoint));
            //TFCRegistries.METALS.register(new Metal(new ResourceLocation(THValues.MODID, metal.mat.getUnlocalizedName()), TIER_0, true, metal.specificHeat, metal.meltingPoint, metal.mat.getMaterialRGB(), null, null));
        }
    }




}
