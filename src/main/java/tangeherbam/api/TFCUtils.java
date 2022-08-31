package tangeherbam.api;

import net.dries007.tfc.api.capability.forge.CapabilityForgeable;
import net.dries007.tfc.api.capability.forge.ForgeableHeatableHandler;
import net.dries007.tfc.api.capability.heat.CapabilityItemHeat;
import net.dries007.tfc.api.capability.heat.ItemHeatHandler;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.minecraft.item.ItemStack;

public class TFCUtils {

    public static void AddGTMetal(ItemStack itemStack, float specificHeat, float meltingPoint) {
        CreateForgableItem(itemStack, specificHeat, meltingPoint);
        CreateHeatableItem(itemStack, specificHeat, meltingPoint);
    }

    public static void CreateForgableItem(ItemStack itemStack, float specificHeat, float meltingPoint) {

        IIngredient<ItemStack> inputIngredient = IIngredient.of(itemStack);
        if(CapabilityForgeable.CUSTOM_ITEMS.get(inputIngredient) != null)
            throw new IllegalStateException("Input already registered in forge capability");
        else
            CapabilityForgeable.CUSTOM_ITEMS.put(inputIngredient, () -> new ForgeableHeatableHandler(null, specificHeat, meltingPoint));
    }

    public static void CreateHeatableItem(ItemStack itemStack, float specificHeat, float meltingPoint) {
        IIngredient<ItemStack> inputIngredient = IIngredient.of(itemStack);
        if(CapabilityItemHeat.CUSTOM_ITEMS.get(inputIngredient) != null)
            throw new IllegalStateException("Input already registered in heat capability");
        else
            CapabilityItemHeat.CUSTOM_ITEMS.put(inputIngredient, () -> new ItemHeatHandler(null, specificHeat, meltingPoint));
    }
}
