package tangeherbam.api;

import com.google.common.base.CaseFormat;
import gregtech.api.GTValues;
import gregtech.api.items.materialitem.MetaPrefixItem;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.info.MaterialIconType;
import gregtech.api.unification.material.properties.IMaterialProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import tangeherbam.THValues;
import tangeherbam.api.material.info.THMaterialIconType;

import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.ore.OrePrefix.Flags.*;

public class OreDictionaries {

    public static final OrePrefix LargeChunk = new OrePrefix("oreChunkLarge", (long)(GTValues.M / 4), null, THMaterialIconType.chunkLarge, ENABLE_UNIFICATION, null);
    public static final OrePrefix MediumChunk = new OrePrefix("oreChunkMedium", (long)(GTValues.M / 8), null, THMaterialIconType.chunkMedium, ENABLE_UNIFICATION, null);
    public static final OrePrefix SmallChunk = new OrePrefix("oreChunkSmall", (long)(GTValues.M / 16), null, THMaterialIconType.chunkSmall, ENABLE_UNIFICATION, null);

    public static final OrePrefix IngotDouble = new OrePrefix("oreIngotDouble", (long)(GTValues.M * 2), null, MaterialIconType.ingotDouble, ENABLE_UNIFICATION, null);
    public static final OrePrefix Rackwheel = new OrePrefix("oreRackwheel", (long)(GTValues.M * 4), null, THMaterialIconType.rackwheel, ENABLE_UNIFICATION, null);
    public static final OrePrefix RackwheelPeice = new OrePrefix("oreRackwheelPiece", (long)(GTValues.M), null, THMaterialIconType.rackwheelPiece, ENABLE_UNIFICATION, null);
    public static final OrePrefix RotorBlade = new OrePrefix("oreRotorBlade", (long)(GTValues.M), null, THMaterialIconType.rotorBlade, ENABLE_UNIFICATION, null);

    public static void registerOrePrefixes() {
        LargeChunk.setGenerationCondition(mat -> mat.hasProperty(PropertyKey.ORE));
        MediumChunk.setGenerationCondition(mat -> mat.hasProperty(PropertyKey.ORE));
        SmallChunk.setGenerationCondition(mat -> mat.hasProperty(PropertyKey.ORE));

        IngotDouble.setGenerationCondition(mat -> mat.hasProperty(PropertyKey.INGOT));
        RotorBlade.setGenerationCondition(mat -> mat.hasFlags(GENERATE_ROTOR));
        Rackwheel.setGenerationCondition(mat -> mat.hasFlags(GENERATE_GEAR));
        RackwheelPeice.setGenerationCondition(mat -> mat.hasFlags(GENERATE_GEAR));

        createMaterialItem(LargeChunk);
        createMaterialItem(MediumChunk);
        createMaterialItem(SmallChunk);

        createMaterialItem(IngotDouble);
        createMaterialItem(RotorBlade);
        createMaterialItem(Rackwheel);
        createMaterialItem(RackwheelPeice);
    }

    public static void createMaterialItem(OrePrefix orePrefix) {
        MetaPrefixItem item = new MetaPrefixItem(orePrefix);
        item.setRegistryName(THValues.MODID, orePrefix.name());
    }
}
