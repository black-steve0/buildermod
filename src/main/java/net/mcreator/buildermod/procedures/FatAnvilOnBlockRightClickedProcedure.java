package net.mcreator.buildermod.procedures;

import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.Blocks;

import net.mcreator.buildermod.BuildermodModElements;
import net.mcreator.buildermod.BuildermodMod;

import java.util.Map;

@BuildermodModElements.ModElement.Tag
public class FatAnvilOnBlockRightClickedProcedure extends BuildermodModElements.ModElement {
	public FatAnvilOnBlockRightClickedProcedure(BuildermodModElements instance) {
		super(instance, 8);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BuildermodMod.LOGGER.warn("Failed to load dependency x for procedure FatAnvilOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BuildermodMod.LOGGER.warn("Failed to load dependency y for procedure FatAnvilOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BuildermodMod.LOGGER.warn("Failed to load dependency z for procedure FatAnvilOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BuildermodMod.LOGGER.warn("Failed to load dependency world for procedure FatAnvilOnBlockRightClicked!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.REDSTONE_BLOCK.getDefaultState().getBlock())
				&& (((world.getBlockState(new BlockPos((int) x, (int) (y + 2), (int) z))).getBlock() == Blocks.SOUL_FIRE.getDefaultState().getBlock())
						&& (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)))).getBlock() == Blocks.GOLD_BLOCK
								.getDefaultState().getBlock())
								&& (((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) (z + 1)))).getBlock() == Blocks.GOLD_BLOCK
										.getDefaultState().getBlock())
										&& ((world.getBlockState(new BlockPos((int) (x + 2), (int) (y - 1), (int) (z + 1))))
												.getBlock() == Blocks.GOLD_BLOCK.getDefaultState().getBlock())))))) {
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				int _amount = (int) 100;
				if (_ent != null)
					_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
							.ifPresent(capability -> capability.drain(_amount, IFluidHandler.FluidAction.EXECUTE));
			}
		}
	}
}
