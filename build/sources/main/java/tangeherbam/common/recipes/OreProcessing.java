package tangeherbam.common.recipes;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMaps;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static tangeherbam.api.material.Materials.*;
import static tangeherbam.api.OreDictionaries.*;

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
                .chancedOutput(gem, Argentite, 2, 2000, 400)
                .chancedOutput(gem, Polybasite, 3, 3000, 500)
                .chancedOutput(gem, Proustite, 2, 4000, 400)
                .output(dust, Stone)
                .EUt(16)
                .duration(30)
                .buildAndRegister();
    }
}
