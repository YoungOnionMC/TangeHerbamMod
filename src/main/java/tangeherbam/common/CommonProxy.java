package tangeherbam.common;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.recipes.logic.OverclockingLogic;
import gregtech.api.sound.GTSounds;
import gregtech.common.ConfigHolder;
import gregtech.common.blocks.MetaBlocks;
import net.dries007.tfc.api.util.FallingBlockManager;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import tangeherbam.THValues;

import tangeherbam.api.material.Materials;
import tangeherbam.api.OreDictionaries;
import tangeherbam.api.material.StoneTypes;
import tangeherbam.common.recipes.MaterialProcessing;
import tangeherbam.common.recipes.OreProcessing;

import static gregtech.api.GregTechAPI.MTE_REGISTRY;

@Mod.EventBusSubscriber(modid = THValues.MODID)
public class CommonProxy {
    public void preInit() {

        OreDictionaries.registerOrePrefixes();
        //Materials.registerGTMetalsAsTFCMetals();
        //Materials.registerMaterials();


    }

    @SubscribeEvent()
    public static void init(RegistryEvent.Register<IRecipe> event) {
        // stone types do not work, please dont uncomment
        //StoneTypes.registerTFCStoneTypes();
        IBlockState state = MetaBlocks.MACHINE.getDefaultState();
        Materials.registerGTMetalsAsTFCMetals();


        FallingBlockManager.SupportFallablesPair gtMachines = new FallingBlockManager.SupportFallablesPair("GregtechMachines");
        FallingBlockManager.addSupportFallablePairToRegistry(gtMachines);
        for(MetaTileEntity mte : MTE_REGISTRY) {
            FallingBlockManager.Specification spec = new FallingBlockManager.Specification(false, ()-> SoundType.METAL.getPlaceSound());
            gtMachines.registerFallable(state, spec);
        }

        for(int size = 0; size < MetaBlocks.ITEM_PIPES.length;) {
            FallingBlockManager.Specification spec = new FallingBlockManager.Specification(true, ()->GTSounds.ASSEMBLER);
            IBlockState pipeBlockState = MetaBlocks.ITEM_PIPES[size++].getBlockState().getBaseState();
            spec.setResultingState(pipeBlockState);
            gtMachines.registerFallable(pipeBlockState, spec);
        }

        for(int size = 0; size < MetaBlocks.FLUID_PIPES.length;) {
            FallingBlockManager.Specification spec = new FallingBlockManager.Specification(true, ()->GTSounds.CHAINSAW_TOOL);
            IBlockState pipeBlockState = MetaBlocks.FLUID_PIPES[size++].getBlockState().getBaseState();
            spec.setResultingState(pipeBlockState);
            gtMachines.registerFallable(pipeBlockState, spec);
        }

        MaterialProcessing.initGeneralOreProcessing();
        OreProcessing.registerAllOreProcessingLines();
        MaterialProcessing.addGTMetalsToTFCAnvil();
    }

}
