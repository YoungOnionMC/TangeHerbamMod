package tangeherbam.common;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.sound.GTSounds;
import gregtech.common.blocks.MetaBlocks;
import net.dries007.tfc.api.util.FallingBlockManager;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import tangeherbam.THValues;

import tangeherbam.api.material.Materials;
import tangeherbam.api.OreDictionaries;
import tangeherbam.common.recipes.OreProcessing;

import static gregtech.api.GregTechAPI.MTE_REGISTRY;

@Mod.EventBusSubscriber(modid = THValues.MODID)
public class CommonProxy {
    public void preInit() {
        OreDictionaries.registerOrePrefixes();
        //Materials.registerMaterials();


    }

    @SubscribeEvent()
    public static void init(RegistryEvent.Register<IRecipe> event) {
        IBlockState state = MetaBlocks.MACHINE.getDefaultState();


        FallingBlockManager.SupportFallablesPair gtMachines = new FallingBlockManager.SupportFallablesPair("GregtechMachines");
        FallingBlockManager.addSupportFallablePairToRegistry(gtMachines);
        for(MetaTileEntity mte : MTE_REGISTRY) {
            FallingBlockManager.Specification spec = new FallingBlockManager.Specification(true, ()->GTSounds.CHEMICAL_REACTOR);
            //spec.setResultingState(Blocks.BEDROCK.getDefaultState());
            //MTE_REGISTRY.getObjectById(MTE_REGISTRY.getIdByObjectName(mte.getHolder().getMetaTileEntity().));
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

        OreProcessing.registerAllOreProcessingLines();
    }

}
