package tangeherbam.api.material;

import crafttweaker.api.minecraft.CraftTweakerMC;
import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.unification.material.Material;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static net.dries007.tfc.types.DefaultRocks.*;
import static tangeherbam.api.material.Materials.*;

import gregtech.api.unification.material.info.MaterialIconType;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.ore.StoneType;
import gregtech.api.unification.stack.MaterialStack;
//import gregtech.api.worldgen2.stonelayer.StoneLayer;
//import gregtech.api.worldgen2.stonelayer.StoneLayerOres;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Rock;
import net.dries007.tfc.objects.blocks.stone.BlockRockRaw;
import net.dries007.tfc.objects.blocks.stone.BlockRockVariant;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.dries007.tfc.types.DefaultRocks;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class StoneTypes {

    public static final List<StoneType> StoneTypeList = new ArrayList<>();

    // STONE TYPES DO NOT WORK NOW FOR SOME FUCKING REASON, EVERYTHING IS JUST GONNA BE STONE
    // - Onion
    public static void registerTFCStoneTypes() {


        registerStoneType(17, "graniteTFC", OrePrefix.oreGranite, Granite, BlockRockVariant.get(TFCRegistries.ROCKS.getValue(GRANITE), Rock.Type.RAW).getDefaultState(), true);

        registerStoneType(18, "dioriteTFC", OrePrefix.oreDiorite, Diorite, BlockRockVariant.get(TFCRegistries.ROCKS.getValue(DIORITE), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreGabbro = new OrePrefix("oreGabbro", -1L, null, MaterialIconType.ore, OrePrefix.Flags.ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);
        oreGabbro.addSecondaryMaterial(new MaterialStack(Gabbro, -1L));
        registerStoneType(19, "gabbroTFC", oreGabbro, Gabbro, BlockRockVariant.get(TFCRegistries.ROCKS.getValue(GABBRO), Rock.Type.RAW).getDefaultState(), true);

        OrePrefix oreShale = new OrePrefix("oreShale", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(20, "shaleTFC", oreShale, Shale, BlockRockVariant.get(TFCRegistries.ROCKS.getValue(SHALE), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreClaystone = new OrePrefix("oreClaystone", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(21, "claystoneTFC", oreClaystone, Claystone, BlockRockVariant.get(TFCRegistries.ROCKS.getValue(CLAYSTONE), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreRocksalt = new OrePrefix("oreRocksalt", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(22, "rocksaltTFC", oreRocksalt, RockSalt, BlockRockVariant.get(TFCRegistries.ROCKS.getValue(ROCKSALT), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreLimestone = new OrePrefix("oreLimestone", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(23, "limestoneTFC", oreLimestone, LimestoneTFC, BlockRockVariant.get(TFCRegistries.ROCKS.getValue(LIMESTONE), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreConglomerate = new OrePrefix("oreConglomerate", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(24, "conglomerateTFC", oreConglomerate, Conglomerate, BlockRockVariant.get(TFCRegistries.ROCKS.getValue(CONGLOMERATE), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreDolomite = new OrePrefix("oreDolomite", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(25, "dolomiteTFC", oreDolomite, Dolomite, BlockRockVariant.get(TFCRegistries.ROCKS.getValue(DOLOMITE), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreChert = new OrePrefix("oreChert", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(26, "chertTFC", oreChert, Chert, BlockRockVariant.get(TFCRegistries.ROCKS.getValue(CHERT), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreChalk = new OrePrefix("oreChalk", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(27, "chalkTFC", oreChalk, Chalk, BlockRockVariant.get(TFCRegistries.ROCKS.getValue(CHALK), Rock.Type.RAW).getDefaultState(), true);
        registerStoneType(28, "basaltTFC", OrePrefix.oreBasalt, Basalt, BlockRockVariant.get(TFCRegistries.ROCKS.getValue(BASALT), Rock.Type.RAW).getDefaultState(), true);
        registerStoneType(29, "andesiteTFC", OrePrefix.oreAndesite, Andesite, BlockRockVariant.get(TFCRegistries.ROCKS.getValue(ANDESITE), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreRhyolite = new OrePrefix("oreRhyolite", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(30, "rhyoliteTFC", oreRhyolite, Rhyolite, BlockRockVariant.get(TFCRegistries.ROCKS.getValue(RHYOLITE), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreDacite = new OrePrefix("oreDacite", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(31, "daciteTFC", oreDacite, Dacite, BlockRockVariant.get(TFCRegistries.ROCKS.getValue(DACITE), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreQuartzite = new OrePrefix("oreQuartzite", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(32, "quartziteTFC", oreQuartzite, Quartzite, BlockRockVariant.get(TFCRegistries.ROCKS.getValue(QUARTZITE), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreSlate = new OrePrefix("oreSlate", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(33, "slateTFC", oreSlate, SlateTFC, BlockRockVariant.get(TFCRegistries.ROCKS.getValue(SLATE), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix orePhyllite = new OrePrefix("orePhyllite", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(34, "phylliteTFC", orePhyllite, Phyllite, BlockRockVariant.get(TFCRegistries.ROCKS.getValue(PHYLLITE), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreSchist = new OrePrefix("oreSchist", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(35, "schistTFC", oreSchist, Schist, BlockRockVariant.get(TFCRegistries.ROCKS.getValue(SCHIST), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreGneiss = new OrePrefix("oreGneiss", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(36, "gneissTFC", oreGneiss, Gneiss, BlockRockVariant.get(TFCRegistries.ROCKS.getValue(GNEISS), Rock.Type.RAW).getDefaultState(), true);
        registerStoneType(37, "marbleTFC", OrePrefix.oreMarble, Marble, BlockRockVariant.get(TFCRegistries.ROCKS.getValue(MARBLE), Rock.Type.RAW).getDefaultState(), true);
    }

    private static void registerStoneType(int id, String name, OrePrefix orePrefix, Material material, IBlockState blockState, boolean shouldBeDroppedAsItem) {
        Supplier<IBlockState> supplier = () -> blockState;
        Predicate<IBlockState> predicate = state -> state.equals(blockState);

        StoneType stoneType = new StoneType(id, name, SoundType.STONE, orePrefix, material, supplier, predicate, shouldBeDroppedAsItem);
        //StoneLayer.LAYERS.add(new StoneLayer(stoneType, blockState, material));
        //StoneLayer.LAYERS.add(new StoneLayer(stoneType, blockState, material,
        //        new StoneLayerOres(gregtech.api.unification.material.Materials.Diamond, GTValues.M / 64, 0, 100)));
        StoneTypeList.add(stoneType);

    }
}
