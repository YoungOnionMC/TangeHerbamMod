package tangeherbam.api.material;


import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static net.dries007.tfc.api.types.Metal.Tier.*;
import static tangeherbam.api.OreDictionaries.*;

import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.crafttweaker.CTMaterialBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Material.Builder;
import gregtech.api.unification.material.info.MaterialFlag;
import gregtech.api.unification.material.properties.IngotProperty;
import gregtech.api.unification.material.properties.OreProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.minecraftforge.registries.IForgeRegistry;
import tangeherbam.api.TFCUtils;
import tangeherbam.common.recipes.GTHeatRecipeMetalMelting;

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
        WroughtIron.addFlags(GENERATE_GEAR, GENERATE_SMALL_GEAR);
    }


    public static class GTMetal {
        public Material mat;
        public float specificHeat;
        public float meltingPoint;
        public Metal.Tier tier;

        public GTMetal(Material mat, float specificHeat, float melt, Metal.Tier tier) {
            this.mat = mat;
            this.specificHeat = specificHeat;
            this.meltingPoint = melt;
            this.tier = tier;
        }
    };

    public static Set<GTMetal> gtMetals = new HashSet<>();

    public static GTMetal getMetal(Material mat) {
        for(GTMetal metal : gtMetals) {
            if(metal.mat == mat)
                return metal;
        }
        return new GTMetal(Copper, .386f, 1084f, TIER_I);
    }

    public static void registerGTMetalsAsTFCMetals() {
        gtMetals.add(new GTMetal(Aluminium, .900f, 1538f, TIER_IV));
        gtMetals.add(new GTMetal(Antimony, .210f, 630f, TIER_I));
        gtMetals.add(new GTMetal(Barium, .200f, 727f, TIER_I));
        gtMetals.add(new GTMetal(Beryllium, 1.83f, 1287f, TIER_I));
        gtMetals.add(new GTMetal(Bismuth, .123f, 271f, TIER_I));
        gtMetals.add(new GTMetal(BismuthBronze, .123f, 271f, TIER_I)); //
        gtMetals.add(new GTMetal(Bronze, .123f, 271f, TIER_I)); //
        gtMetals.add(new GTMetal(BlackBronze, .123f, 271f, TIER_I)); //
        gtMetals.add(new GTMetal(Brass, .123f, 271f, TIER_I)); //
        gtMetals.add(new GTMetal(Cadmium, .23f, 321f, TIER_I));
        gtMetals.add(new GTMetal(Calcium, .63f, 842f, TIER_I));
        gtMetals.add(new GTMetal(Copper, .386f, 1084f, TIER_I));
        gtMetals.add(new GTMetal(AnnealedCopper, .386f, 1084f, TIER_II));
        gtMetals.add(new GTMetal(Chrome, .46f, 1907f, TIER_IV));
        gtMetals.add(new GTMetal(Cobalt, .42f, 1495f, TIER_III));
        gtMetals.add(new GTMetal(CobaltBrass, .42f, 1495f, TIER_III));
        gtMetals.add(new GTMetal(Electrum, .15f, 30f, TIER_II)); //
        gtMetals.add(new GTMetal(Gallium, .37f, 30f, TIER_II));
        gtMetals.add(new GTMetal(Germanium, .32f, 938f, TIER_IV));
        gtMetals.add(new GTMetal(Gold, .126f, 1064f, TIER_II));
        gtMetals.add(new GTMetal(RoseGold, .126f, 1064f, TIER_II)); //
        gtMetals.add(new GTMetal(Hafnium, .14f, 2233f, TIER_VI));
        gtMetals.add(new GTMetal(Indium, .24f, 156f, TIER_III));
        gtMetals.add(new GTMetal(Invar, .24f, 156f, TIER_III)); //
        gtMetals.add(new GTMetal(Iridium, .13f, 2446f, TIER_VI));
        gtMetals.add(new GTMetal(Lead, .128f, 327f, TIER_II));
        gtMetals.add(new GTMetal(Lithium, 3.57f, 180f, TIER_II));
        gtMetals.add(new GTMetal(Lutetium, .15f, 1652f, TIER_V));
        gtMetals.add(new GTMetal(Magnesium, 1.05f, 650f, TIER_II));
        gtMetals.add(new GTMetal(Manganese, .48f, 1246, TIER_II));
        gtMetals.add(new GTMetal(Mercury, .14f, 0f, TIER_I)); // fuck you irl chemistry i guess ????????
        gtMetals.add(new GTMetal(Molybdenum, .25f, 2623f, TIER_III));
        gtMetals.add(new GTMetal(Nickel, .44f, 1455f, TIER_II));
        gtMetals.add(new GTMetal(Niobium, .27f, 2477f, TIER_V));
        gtMetals.add(new GTMetal(Neodymium, .19f, 1024f, TIER_V));
        gtMetals.add(new GTMetal(Osmium, .13f, 3033f, TIER_VI));
        gtMetals.add(new GTMetal(Palladium, .24f, 1554f, TIER_VI));
        gtMetals.add(new GTMetal(Platinum, .13f, 1768f, TIER_V));
        gtMetals.add(new GTMetal(Potassium, .75f, 64f, TIER_II));
        gtMetals.add(new GTMetal(Rhenium, .14f, 3186f, TIER_VI));
        gtMetals.add(new GTMetal(Rhodium, .24f, 1964f, TIER_VI));
        gtMetals.add(new GTMetal(Rubidium, .36f, 39f, TIER_V));
        gtMetals.add(new GTMetal(Ruthenium, .24f, 2334f, TIER_VI));
        gtMetals.add(new GTMetal(Scandium, .57f, 1541f, TIER_V));
        gtMetals.add(new GTMetal(Silicon, .71f, 1414f, TIER_III));
        gtMetals.add(new GTMetal(Silver, .233f, 961f, TIER_III));
        gtMetals.add(new GTMetal(SterlingSilver, .233f, 961f, TIER_III)); //
        gtMetals.add(new GTMetal(Sodium, 1.21f, 98f, TIER_II));
        gtMetals.add(new GTMetal(Steel, .466f, 1540f, TIER_IV));
        gtMetals.add(new GTMetal(BlackSteel, .466f, 1540f, TIER_V)); //
        gtMetals.add(new GTMetal(BlueSteel, .466f, 1540f, TIER_VI)); //
        gtMetals.add(new GTMetal(DamascusSteel, .466f, 1540f, TIER_V)); //
        gtMetals.add(new GTMetal(RedSteel, .466f, 1540f, TIER_VI)); //
        gtMetals.add(new GTMetal(StainlessSteel, .5f, 1530f, TIER_V));
        gtMetals.add(new GTMetal(VanadiumSteel, .5f, 1530f, TIER_VI)); //
        gtMetals.add(new GTMetal(Strontium, .30f, 777f, TIER_V));
        gtMetals.add(new GTMetal(Tantalum, .14f, 3017f, TIER_VI));
        gtMetals.add(new GTMetal(Thallium, .13f, 577f, TIER_V));
        gtMetals.add(new GTMetal(Tin, .21f, 231f, TIER_I));
        gtMetals.add(new GTMetal(Titanium, .54f, 1941f, TIER_VI));
        gtMetals.add(new GTMetal(Tungsten, .134f, 3422f, TIER_VI));
        gtMetals.add(new GTMetal(Vanadium, .39f, 2183f, TIER_V));
        gtMetals.add(new GTMetal(Iron, .5f, 1538f, TIER_III));
        gtMetals.add(new GTMetal(WroughtIron, .5f, 1538f, TIER_III));
        gtMetals.add(new GTMetal(Yttrium, .3f, 1800f, TIER_I));
        gtMetals.add(new GTMetal(Zinc, .387f, 420f, TIER_I));
        gtMetals.add(new GTMetal(Zirconium, .27f, 1852f, TIER_I));

        List<OrePrefix> customOrePrefixes = new ArrayList<OrePrefix>();
        customOrePrefixes.add(IngotDouble);
        customOrePrefixes.add(RotorBlade);
        customOrePrefixes.add(RackwheelPeice);
        customOrePrefixes.add(Rackwheel);

        IForgeRegistry<HeatRecipe> r = TFCRegistries.HEAT;

        for(GTMetal metal : gtMetals) {
            Material mat = metal.mat;

            r.register(new GTHeatRecipeMetalMelting(IIngredient.of(OreDictUnifier.get(ingot, mat)), metal.meltingPoint, metal.tier).setRegistryName("TANGEHERBAM" + metal.mat.getUnlocalizedName() + "_melting"));

            if(mat.hasProperty(PropertyKey.INGOT))
                TFCUtils.AddGTMetal(OreDictUnifier.get(ingot, mat), metal.specificHeat, metal.meltingPoint);



            for(OrePrefix prefix : customOrePrefixes) {
                if (prefix.doGenerateItem(mat))
                    TFCUtils.AddGTMetal(OreDictUnifier.get(prefix, mat), metal.specificHeat, metal.meltingPoint);
            }

            if(mat.hasFlags(GENERATE_ROD))
                TFCUtils.AddGTMetal(OreDictUnifier.get(stick, mat), metal.specificHeat, metal.meltingPoint);
            if(mat.hasFlags(GENERATE_LONG_ROD))
                TFCUtils.AddGTMetal(OreDictUnifier.get(stickLong, mat), metal.specificHeat, metal.meltingPoint);
            if(mat.hasFlags(GENERATE_FOIL))
                TFCUtils.AddGTMetal(OreDictUnifier.get(foil, mat), metal.specificHeat, metal.meltingPoint);
            if(mat.hasFlags(GENERATE_PLATE))
                TFCUtils.AddGTMetal(OreDictUnifier.get(plate, mat), metal.specificHeat, metal.meltingPoint);
            if(mat.hasFlags(GENERATE_FRAME))
                TFCUtils.AddGTMetal(OreDictUnifier.get(frameGt, mat), metal.specificHeat, metal.meltingPoint);
            if(mat.hasFlags(GENERATE_BOLT_SCREW)) {
                TFCUtils.AddGTMetal(OreDictUnifier.get(bolt, mat), metal.specificHeat, metal.meltingPoint);
                TFCUtils.AddGTMetal(OreDictUnifier.get(screw, mat), metal.specificHeat, metal.meltingPoint);
            }
            if(mat.hasFlags(GENERATE_ROTOR))
                TFCUtils.AddGTMetal(OreDictUnifier.get(rotor, mat), metal.specificHeat, metal.meltingPoint);
            if(mat.hasFlags(GENERATE_GEAR))
                TFCUtils.AddGTMetal(OreDictUnifier.get(gear, mat), metal.specificHeat, metal.meltingPoint);
            if(mat.hasFlags(GENERATE_SMALL_GEAR))
                TFCUtils.AddGTMetal(OreDictUnifier.get(gearSmall, mat), metal.specificHeat, metal.meltingPoint);
            if(mat.hasFlags(GENERATE_SPRING))
                TFCUtils.AddGTMetal(OreDictUnifier.get(spring, mat), metal.specificHeat, metal.meltingPoint);
            if(mat.hasFlags(GENERATE_SPRING_SMALL))
                TFCUtils.AddGTMetal(OreDictUnifier.get(springSmall, mat), metal.specificHeat, metal.meltingPoint);
            if(mat.hasFlags(GENERATE_RING))
                TFCUtils.AddGTMetal(OreDictUnifier.get(ring, mat), metal.specificHeat, metal.meltingPoint);
            if(mat.hasFlags(GENERATE_ROUND))
                TFCUtils.AddGTMetal(OreDictUnifier.get(round, mat), metal.specificHeat, metal.meltingPoint);
            if(mat.hasFlags(GENERATE_DENSE))
                TFCUtils.AddGTMetal(OreDictUnifier.get(plateDense, mat), metal.specificHeat, metal.meltingPoint);
        }

        //for(GTMetal metal : gtMetals) {

            //CapabilityItemHeat.CUSTOM_ITEMS.put(IIngredient.of(OreDictUnifier.get(ingot, metal.mat)), () -> new ItemHeatHandler(null, metal.specificHeat, metal.meltingPoint));
            //TFCRegistries.METALS.register(new Metal(new ResourceLocation(THValues.MODID, metal.mat.getUnlocalizedName()), TIER_0, true, metal.specificHeat, metal.meltingPoint, metal.mat.getMaterialRGB(), null, null));
        //}
    }




}
