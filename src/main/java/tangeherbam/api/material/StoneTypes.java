package tangeherbam.api.material;

import crafttweaker.api.minecraft.CraftTweakerMC;
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
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Rock;
import net.dries007.tfc.objects.blocks.stone.BlockRockRaw;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.dries007.tfc.types.DefaultRocks;
import net.minecraft.util.ResourceLocation;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class StoneTypes {

    // STONE TYPES DO NOT WORK NOW FOR SOME FUCKING REASON, EVERYTHING IS JUST GONNA BE STONE
    // - Onion
    public static void registerTFCStoneTypes() {
        registerStoneType(17, "graniteTFC", OrePrefix.oreGranite, Granite, BlockRockRaw.get(TFCRegistries.ROCKS.getValue(GRANITE), Rock.Type.RAW).getDefaultState(), true);

        registerStoneType(18, "dioriteTFC", OrePrefix.oreDiorite, Diorite, BlockRockRaw.get(TFCRegistries.ROCKS.getValue(DIORITE), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreGabbro = new OrePrefix("oreGabbro", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        oreGabbro.addSecondaryMaterial(new MaterialStack(Gabbro, -1L));
        registerStoneType(19, "gabbro", oreGabbro, Gabbro, BlockRockRaw.get(TFCRegistries.ROCKS.getValue(GABBRO), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreShale = new OrePrefix("oreShale", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(20, "shale", oreShale, Shale, BlockRockRaw.get(TFCRegistries.ROCKS.getValue(SHALE), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreClaystone = new OrePrefix("oreClaystone", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(21, "claystone", oreClaystone, Claystone, BlockRockRaw.get(TFCRegistries.ROCKS.getValue(CLAYSTONE), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreRocksalt = new OrePrefix("oreRocksalt", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(22, "rocksalt", oreRocksalt, RockSalt, BlockRockRaw.get(TFCRegistries.ROCKS.getValue(ROCKSALT), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreLimestone = new OrePrefix("oreLimestone", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(23, "limestone", oreLimestone, Limestone, BlockRockRaw.get(TFCRegistries.ROCKS.getValue(LIMESTONE), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreConglomerate = new OrePrefix("oreConglomerate", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(24, "conglomerate", oreConglomerate, Conglomerate, BlockRockRaw.get(TFCRegistries.ROCKS.getValue(CONGLOMERATE), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreDolomite = new OrePrefix("oreDolomite", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(25, "dolomite", oreDolomite, Dolomite, BlockRockRaw.get(TFCRegistries.ROCKS.getValue(DOLOMITE), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreChert = new OrePrefix("oreChert", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(26, "chert", oreChert, Chert, BlockRockRaw.get(TFCRegistries.ROCKS.getValue(CHERT), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreChalk = new OrePrefix("oreChalk", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(27, "chalk", oreChalk, Chalk, BlockRockRaw.get(TFCRegistries.ROCKS.getValue(CHALK), Rock.Type.RAW).getDefaultState(), true);
        registerStoneType(18, "basalt", OrePrefix.oreBasalt, Basalt, BlockRockRaw.get(TFCRegistries.ROCKS.getValue(BASALT), Rock.Type.RAW).getDefaultState(), true);
        registerStoneType(29, "andesite", OrePrefix.oreAndesite, Andesite, BlockRockRaw.get(TFCRegistries.ROCKS.getValue(ANDESITE), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreRhyolite = new OrePrefix("oreRhyolite", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(30, "rhyolite", oreRhyolite, Rhyolite, BlockRockRaw.get(TFCRegistries.ROCKS.getValue(RHYOLITE), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreDacite = new OrePrefix("oreDacite", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(31, "dacite", oreDacite, Dacite, BlockRockRaw.get(TFCRegistries.ROCKS.getValue(DACITE), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreQuartzite = new OrePrefix("oreQuartzite", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(32, "quartzite", oreQuartzite, Quartzite, BlockRockRaw.get(TFCRegistries.ROCKS.getValue(QUARTZITE), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreSlate = new OrePrefix("oreSlate", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(33, "slate", oreSlate, Slate, BlockRockRaw.get(TFCRegistries.ROCKS.getValue(SLATE), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix orePhyllite = new OrePrefix("orePhyllite", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(34, "phyllite", orePhyllite, Phyllite, BlockRockRaw.get(TFCRegistries.ROCKS.getValue(PHYLLITE), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreSchist = new OrePrefix("oreSchist", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(35, "schist", oreSchist, Schist, BlockRockRaw.get(TFCRegistries.ROCKS.getValue(SCHIST), Rock.Type.RAW).getDefaultState(), true);
        OrePrefix oreGneiss = new OrePrefix("oreGneiss", -1L, null, MaterialIconType.ore, 1L, OrePrefix.Conditions.hasOreProperty);
        registerStoneType(36, "gneiss", oreGneiss, Gneiss, BlockRockRaw.get(TFCRegistries.ROCKS.getValue(GNEISS), Rock.Type.RAW).getDefaultState(), true);
        registerStoneType(37, "marble", OrePrefix.oreMarble, Marble, BlockRockRaw.get(TFCRegistries.ROCKS.getValue(MARBLE), Rock.Type.RAW).getDefaultState(), true);

    }

    private static void registerStoneType(int id, String name, OrePrefix orePrefix, Material material, IBlockState blockState, boolean shouldBeDroppedAsItem) {
        Supplier<net.minecraft.block.state.IBlockState> supplier = () -> blockState;
        Predicate<IBlockState> spawnPredicate = state -> state.equals(blockState);

        StoneType stoneType = new StoneType(id, name, SoundType.STONE, orePrefix, material, supplier, spawnPredicate, shouldBeDroppedAsItem);

    }
}
