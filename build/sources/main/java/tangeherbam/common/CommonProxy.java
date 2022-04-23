package tangeherbam.common;

import gregtech.api.sound.GTSounds;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.steam.SteamAlloySmelter;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Rock;
import net.dries007.tfc.api.util.FallingBlockManager;
import net.dries007.tfc.objects.blocks.stone.BlockRockVariant;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import tangeherbam.THValues;

import gregtech.common.metatileentities.MetaTileEntities;

import static net.dries007.tfc.api.util.FallingBlockManager.Specification.*;

@Mod.EventBusSubscriber(modid = THValues.MODID)
public class CommonProxy {
    public void preInit() {
        IBlockState state = MetaBlocks.MACHINE.getDefaultState();
        FallingBlockManager.Specification spec = new FallingBlockManager.Specification(true, ()->GTSounds.CHEMICAL_REACTOR);
        //spec = new FallingBlockManager.Specification(false, ()->GTSounds.ARC);
        //for(Rock rock : TFCRegistries.ROCKS.getValuesCollection()) {
            spec.setResultingState(MetaBlocks.ASPHALT.getDefaultState());
            FallingBlockManager.registerFallable(state, spec);
        //}
    }

    @SubscribeEvent()
    public static void init(RegistryEvent.Register<IRecipe> event) {

    }

}
