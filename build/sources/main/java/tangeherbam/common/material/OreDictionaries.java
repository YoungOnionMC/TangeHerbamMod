package tangeherbam.common.material;

import com.google.common.base.CaseFormat;
import gregtech.api.GTValues;
import gregtech.api.items.materialitem.MetaPrefixItem;
import gregtech.api.unification.material.info.MaterialIconType;
import gregtech.api.unification.material.properties.IMaterialProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import tangeherbam.THValues;

import static gregtech.api.unification.ore.OrePrefix.Flags.*;

public class OreDictionaries {

    public static final OrePrefix LargeChunk = new OrePrefix("oreChunkLarge", (long)(GTValues.M / 4), null, MaterialIconType.gemFlawless, ENABLE_UNIFICATION, null);
    public static final OrePrefix MediumChunk = new OrePrefix("oreChunkMedium", (long)(GTValues.M / 8), null, MaterialIconType.gemChipped, ENABLE_UNIFICATION, null);
    public static final OrePrefix SmallChunk = new OrePrefix("oreChunkSmall", (long)(GTValues.M / 16), null, MaterialIconType.dust, ENABLE_UNIFICATION, null);

    public static void registerOrePrefixes() {
        LargeChunk.setGenerationCondition(mat -> mat.hasProperty(PropertyKey.ORE));
        MediumChunk.setGenerationCondition(mat -> mat.hasProperty(PropertyKey.ORE));
        SmallChunk.setGenerationCondition(mat -> mat.hasProperty(PropertyKey.ORE));

        createMaterialItem(LargeChunk);
        createMaterialItem(MediumChunk);
        createMaterialItem(SmallChunk);
    }

    public static void createMaterialItem(OrePrefix orePrefix) {
        MetaPrefixItem item = new MetaPrefixItem(orePrefix);
        item.setRegistryName(THValues.MODID, orePrefix.name());
    }
}
