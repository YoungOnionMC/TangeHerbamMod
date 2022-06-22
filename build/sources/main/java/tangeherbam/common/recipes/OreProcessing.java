package tangeherbam.common.recipes;

import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.crafttweaker.ChancedEntry;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.ore.OrePrefix;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static tangeherbam.common.material.Materials.*;
import static tangeherbam.common.material.OreDictionaries.*;

public class OreProcessing {

    public static void registerAllOreProcessingLines() {
        registerSilverChain();
    }

    public static void registerSilverChain() {


        RecipeMaps.MACERATOR_RECIPES.recipeBuilder()
                .input(ore, Galena, 1)
                .output(LargeChunk, Galena, 4)
                .EUt(16)
                .duration(30)
                .buildAndRegister();

        RecipeMaps.CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(LargeChunk, Galena)
                .fluidInputs(Mercury.getFluid(1000))
                .chancedOutput(gem, Argentite, 2, 20, 4)
                .chancedOutput(gem, Polybasite, 3, 30, 5)
                .chancedOutput(gem, Proustite, 2, 40, 4)
                .output(dust, Stone)
                .EUt(16)
                .duration(30)
                .buildAndRegister();
    }
}
