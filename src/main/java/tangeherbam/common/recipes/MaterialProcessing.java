package tangeherbam.common.recipes;

import gregtech.api.GTValues;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.IngotProperty;
import gregtech.api.unification.material.properties.OreProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import net.dries007.tfc.api.recipes.WeldingRecipe;
import net.dries007.tfc.api.recipes.anvil.AnvilRecipe;
import net.dries007.tfc.api.recipes.quern.QuernRecipe;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.dries007.tfc.util.skills.SmithingSkill;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import tangeherbam.api.OreDictionaries;


import java.util.HashMap;
import java.util.Map;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static net.dries007.tfc.util.forge.ForgeRule.*;
import static tangeherbam.THValues.MODID;
import static tangeherbam.api.OreDictionaries.*;
import static tangeherbam.common.metaitem.THItems.*;

public class MaterialProcessing {

    public static void removeDefaultTFCRecipes() {

    }


    public static void initGeneralOreProcessing() {
        OrePrefix.ore.addProcessingHandler(PropertyKey.ORE, MaterialProcessing::makeOreChunks);
    }

    public static void makeOreChunks(OrePrefix prefix, Material material, OreProperty property) {

        TFCRegistries.QUERN.register(new QuernRecipe(IIngredient.of(OreDictUnifier.get(LargeChunk, material)), OreDictUnifier.get(MediumChunk, material, 2)).setRegistryName(material.getUnlocalizedName() + "_medium_chunk_grinding_quern"));
        TFCRegistries.QUERN.register(new QuernRecipe(IIngredient.of(OreDictUnifier.get(MediumChunk, material)), OreDictUnifier.get(SmallChunk, material, 2)).setRegistryName(material.getUnlocalizedName() + "_small_chunk_grinding_quern"));

        // TODO check if material is directly smeltable or a gem
        if(material.hasProperty(PropertyKey.GEM) || !material.hasFlags(NO_SMELTING))
            TFCRegistries.QUERN.register(new QuernRecipe(IIngredient.of(OreDictUnifier.get(SmallChunk, material)), OreDictUnifier.get(dust, material)).setRegistryName(material.getUnlocalizedName() + "_dust_grinding_quern"));


        RecipeMaps.MACERATOR_RECIPES.recipeBuilder()
                .input(LargeChunk, material)
                .outputs(OreDictUnifier.get(MediumChunk, material, 2))
                .EUt(8)
                .duration(40)
                .buildAndRegister();

        RecipeMaps.MACERATOR_RECIPES.recipeBuilder()
                .input(MediumChunk, material)
                .outputs(OreDictUnifier.get(SmallChunk, material, 2))
                .EUt(8)
                .duration(25)
                .buildAndRegister();
    }

    public static void addGTMetalsToTFCAnvil() {
        initGTMetalTiers();
        OrePrefix.ingot.addProcessingHandler(PropertyKey.INGOT, MaterialProcessing::makePlates);
        OrePrefix.ingot.addProcessingHandler(PropertyKey.INGOT, MaterialProcessing::makeRods);
        OrePrefix.ingot.addProcessingHandler(PropertyKey.INGOT, MaterialProcessing::makeGears);
        OrePrefix.nugget.addProcessingHandler(PropertyKey.INGOT, MaterialProcessing::makeRounds);
        OrePrefix.stick.addProcessingHandler(PropertyKey.INGOT, MaterialProcessing::makeSprings);
        OrePrefix.ingot.addProcessingHandler(PropertyKey.INGOT, MaterialProcessing::makeRotors);
        //OrePrefix.ingot.addProcessingHandler(PropertyKey.INGOT, TFCDefaults::makeRods);
        //OrePrefix.ingot.addProcessingHandler(PropertyKey.INGOT, TFCDefaults::makeRods);


    }

    public static void makePlates(OrePrefix prefix, Material material, IngotProperty property) {
        Metal.Tier metalTier = Metal.Tier.TIER_0;
        if(metals.containsKey(material))
            metalTier = metals.get(material);

        if(material.hasFlag(GENERATE_PLATE) && metalTier != Metal.Tier.TIER_0) {
            TFCRegistries.WELDING.register(new WeldingRecipe(new ResourceLocation(MODID, material.getUnlocalizedName() + "_double_ingot"), IIngredient.of(OreDictUnifier.get(ingot, material)), IIngredient.of(OreDictUnifier.get(ingot, material)), OreDictUnifier.get(IngotDouble, material), metalTier));
            TFCRegistries.ANVIL.register(new AnvilRecipe(new ResourceLocation(MODID, material.getUnlocalizedName() + "_plate"),
                    IIngredient.of(OreDictUnifier.get(OreDictionaries.IngotDouble, material)), OreDictUnifier.get(plate, material), metalTier, SmithingSkill.Type.GENERAL, DRAW_THIRD_LAST, DRAW_SECOND_LAST, SHRINK_LAST));

        }
    }

    public static void makeRods(OrePrefix prefix, Material material, IngotProperty property) {
        Metal.Tier metalTier = Metal.Tier.TIER_0;
        if(metals.containsKey(material))
            metalTier = metals.get(material);

        if(material.hasFlag(GENERATE_ROD) && metalTier != Metal.Tier.TIER_0) {
            TFCRegistries.ANVIL.register(new AnvilRecipe(new ResourceLocation(MODID, material.getUnlocalizedName() + "_rod"),
                    IIngredient.of(OreDictUnifier.get(prefix, material)), OreDictUnifier.get(stick, material), metalTier, SmithingSkill.Type.GENERAL, DRAW_THIRD_LAST, DRAW_SECOND_LAST, SHRINK_LAST));
        }
        if(material.hasFlag(GENERATE_LONG_ROD) && metalTier != Metal.Tier.TIER_0) {
            TFCRegistries.WELDING.register(new WeldingRecipe(new ResourceLocation(MODID, material.getUnlocalizedName() + "_long_rod"), IIngredient.of(OreDictUnifier.get(stick, material)), IIngredient.of(OreDictUnifier.get(stick, material)), OreDictUnifier.get(stickLong, material), metalTier));
        }
    }

    public static void makeGears(OrePrefix prefix, Material material, IngotProperty property) {
        Metal.Tier metalTier = Metal.Tier.TIER_0;
        if(metals.containsKey(material))
            metalTier = metals.get(material);

        IIngredient<ItemStack> bearing;
        if(metalTier.ordinal() <= Metal.Tier.TIER_II.ordinal())
            bearing = IIngredient.of(TIN_BEARING);
        else if(metalTier.ordinal() <= Metal.Tier.TIER_IV.ordinal())
            bearing = IIngredient.of(ROSE_GOLD_BEARING);
        else
            bearing = IIngredient.of(STEEL_BEARING);

        if(material.hasFlag(GENERATE_GEAR) && metalTier != Metal.Tier.TIER_0) {
            TFCRegistries.ANVIL.register(new AnvilRecipe(new ResourceLocation(MODID, material.getUnlocalizedName() + "_rackwheel_piece"),
                    IIngredient.of(OreDictUnifier.get(plateDouble, material)), OreDictUnifier.get(OreDictionaries.RackwheelPeice, material, 3), metalTier, SmithingSkill.Type.GENERAL, SHRINK_THIRD_LAST, BEND_SECOND_LAST, PUNCH_LAST));

            ModHandler.addShapelessRecipe(material.getUnlocalizedName() + "_rackwheel_piece_upcraft", OreDictUnifier.get(Rackwheel, material),
                    new UnificationEntry(OreDictionaries.RackwheelPeice, material),
                    new UnificationEntry(OreDictionaries.RackwheelPeice, material),
                    new UnificationEntry(OreDictionaries.RackwheelPeice, material),
                    new UnificationEntry(OreDictionaries.RackwheelPeice, material));

            TFCRegistries.WELDING.register(new WeldingRecipe(new ResourceLocation(MODID, material.getUnlocalizedName() + "_gear"),
                    IIngredient.of(OreDictUnifier.get(Rackwheel, material)), bearing,
                    OreDictUnifier.get(gear, material), metalTier));
        }

        if(material.hasFlag(GENERATE_SMALL_GEAR) && metalTier != Metal.Tier.TIER_0) {
            TFCRegistries.ANVIL.register(new AnvilRecipe(new ResourceLocation(MODID, material.getUnlocalizedName() + "_gear_small"),
                    IIngredient.of(OreDictUnifier.get(plate, material)), OreDictUnifier.get(gearSmall, material), metalTier, SmithingSkill.Type.GENERAL, SHRINK_THIRD_LAST, BEND_SECOND_LAST, PUNCH_LAST));
        }
    }

    public static void makeRounds(OrePrefix prefix, Material material, IngotProperty property) {
        Metal.Tier metalTier = Metal.Tier.TIER_0;
        if(metals.containsKey(material))
            metalTier = metals.get(material);

        if(material.hasFlag(GENERATE_ROUND) && metalTier != Metal.Tier.TIER_0) {
            TFCRegistries.ANVIL.register(new AnvilRecipe(new ResourceLocation(MODID, material.getUnlocalizedName() + "_round"),
                    IIngredient.of(OreDictUnifier.get(prefix, material)), OreDictUnifier.get(round, material), metalTier, SmithingSkill.Type.GENERAL, PUNCH_NOT_LAST, HIT_NOT_LAST, SHRINK_LAST));
        }
    }

    public static void makeSprings(OrePrefix prefix, Material material, IngotProperty property) {
        Metal.Tier metalTier = Metal.Tier.TIER_0;
        if(metals.containsKey(material))
            metalTier = metals.get(material);

        if(material.hasFlag(GENERATE_SPRING) && metalTier != Metal.Tier.TIER_0) {
            TFCRegistries.ANVIL.register(new AnvilRecipe(new ResourceLocation(MODID, material.getUnlocalizedName() + "_spring"),
                    IIngredient.of(OreDictUnifier.get(stickLong, material)), OreDictUnifier.get(spring, material), metalTier, SmithingSkill.Type.GENERAL, PUNCH_NOT_LAST, BEND_NOT_LAST, BEND_LAST));
        }

        if(material.hasFlag(GENERATE_SPRING_SMALL) && metalTier != Metal.Tier.TIER_0) {
            TFCRegistries.ANVIL.register(new AnvilRecipe(new ResourceLocation(MODID, material.getUnlocalizedName() + "_spring_small"),
                    IIngredient.of(OreDictUnifier.get(stick, material)), OreDictUnifier.get(springSmall, material), metalTier, SmithingSkill.Type.GENERAL, PUNCH_NOT_LAST, DRAW_NOT_LAST, BEND_LAST));
        }
    }

    public static void makeRotors(OrePrefix prefix, Material material, IngotProperty property) {
        Metal.Tier metalTier = Metal.Tier.TIER_0;
        if(metals.containsKey(material))
            metalTier = metals.get(material);

        if(material.hasFlag(GENERATE_ROTOR) && metalTier != Metal.Tier.TIER_0) {
            TFCRegistries.ANVIL.register(new AnvilRecipe(new ResourceLocation(MODID, material.getUnlocalizedName() + "_rotor_blade"),
                    IIngredient.of(OreDictUnifier.get(plate, material)), OreDictUnifier.get(OreDictionaries.RotorBlade, material), metalTier, SmithingSkill.Type.GENERAL, PUNCH_NOT_LAST, HIT_NOT_LAST, SHRINK_LAST));

            ModHandler.addShapedRecipe(material.getUnlocalizedName() + "_rotor", OreDictUnifier.get(rotor, material),
                    "BhB",
                    "SRf",
                    "BdB",
                    'B', OreDictUnifier.get(OreDictionaries.RotorBlade, material),
                    'R', OreDictUnifier.get(ring, material),
                    'S', OreDictUnifier.get(screw, material));

        }
    }

    public static Map<Material, Metal.Tier> metals = new HashMap<Material, Metal.Tier>();

    public static void initGTMetalTiers() {
        metals.put(Iron, Metal.Tier.TIER_III);
        metals.put(WroughtIron, Metal.Tier.TIER_III);
        metals.put(Steel, Metal.Tier.TIER_IV);
        metals.put(BlackSteel, Metal.Tier.TIER_V);
        metals.put(VanadiumSteel, Metal.Tier.TIER_V);
        metals.put(RedSteel, Metal.Tier.TIER_VI);
        metals.put(BlueSteel, Metal.Tier.TIER_VI);
        metals.put(Bronze, Metal.Tier.TIER_II);
        metals.put(BismuthBronze, Metal.Tier.TIER_II);
        metals.put(BlackBronze, Metal.Tier.TIER_II);
        metals.put(Gold, Metal.Tier.TIER_III);
        metals.put(RoseGold, Metal.Tier.TIER_IV);
        metals.put(Silver, Metal.Tier.TIER_III);
        metals.put(SterlingSilver, Metal.Tier.TIER_IV);
        metals.put(Electrum, Metal.Tier.TIER_IV);
        metals.put(DamascusSteel, Metal.Tier.TIER_V);
        metals.put(Copper, Metal.Tier.TIER_I);
        metals.put(AnnealedCopper, Metal.Tier.TIER_II);
        metals.put(Tin, Metal.Tier.TIER_I);
        metals.put(Bismuth, Metal.Tier.TIER_I);
        metals.put(Lead, Metal.Tier.TIER_I);
        metals.put(Magnesium, Metal.Tier.TIER_I);
        metals.put(Gallium, Metal.Tier.TIER_I);
        metals.put(Aluminium, Metal.Tier.TIER_IV);
        metals.put(Chrome, Metal.Tier.TIER_IV);
        metals.put(Manganese, Metal.Tier.TIER_II);
        metals.put(Neodymium, Metal.Tier.TIER_VI);
        metals.put(Niobium, Metal.Tier.TIER_VI);
        metals.put(Titanium, Metal.Tier.TIER_VI);
        metals.put(Platinum, Metal.Tier.TIER_V);
        metals.put(Tungsten, Metal.Tier.TIER_VI);
        metals.put(Uranium235, Metal.Tier.TIER_III);
        metals.put(Zinc, Metal.Tier.TIER_I);
        metals.put(Brass, Metal.Tier.TIER_I);
        metals.put(CobaltBrass, Metal.Tier.TIER_IV);
        metals.put(Cobalt, Metal.Tier.TIER_III);
        metals.put(Invar, Metal.Tier.TIER_III);
        metals.put(Kanthal, Metal.Tier.TIER_IV);
        metals.put(Nichrome, Metal.Tier.TIER_V);
        metals.put(StainlessSteel, Metal.Tier.TIER_V);
        metals.put(HSSG, Metal.Tier.TIER_VI);
        metals.put(HSSE, Metal.Tier.TIER_VI);
        metals.put(HSSS, Metal.Tier.TIER_VI);
    }
}
