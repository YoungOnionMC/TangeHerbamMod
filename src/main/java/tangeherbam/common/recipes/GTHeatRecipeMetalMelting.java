package tangeherbam.common.recipes;

import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.stack.MaterialStack;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import tangeherbam.api.material.Materials;

import javax.annotation.Nullable;

import static tangeherbam.api.material.Materials.gtMetals;

public class GTHeatRecipeMetalMelting extends HeatRecipe {


    public GTHeatRecipeMetalMelting(IIngredient<ItemStack> ingredient, float transformTemp, Metal.Tier minTier) {
        super(ingredient, transformTemp, minTier);
    }

    @Nullable
    @Override
    public FluidStack getOutputFluid(ItemStack input) {
        MaterialStack matStack = OreDictUnifier.getMaterial(input);
        Material mat = matStack.material;
        for(Materials.GTMetal metal : gtMetals) {
            if(metal.mat == mat) {
                return new FluidStack(mat.getFluid(), (int)matStack.amount);
            }
        }

        return super.getOutputFluid(input);
    }
}
