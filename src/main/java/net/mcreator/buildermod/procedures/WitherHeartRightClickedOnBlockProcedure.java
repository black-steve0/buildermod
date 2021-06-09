package net.mcreator.buildermod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.buildermod.BuildermodModElements;
import net.mcreator.buildermod.BuildermodMod;

import java.util.Map;

@BuildermodModElements.ModElement.Tag
public class WitherHeartRightClickedOnBlockProcedure extends BuildermodModElements.ModElement {
	public WitherHeartRightClickedOnBlockProcedure(BuildermodModElements instance) {
		super(instance, 65);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BuildermodMod.LOGGER.warn("Failed to load dependency x for procedure WitherHeartRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BuildermodMod.LOGGER.warn("Failed to load dependency y for procedure WitherHeartRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BuildermodMod.LOGGER.warn("Failed to load dependency z for procedure WitherHeartRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BuildermodMod.LOGGER.warn("Failed to load dependency world for procedure WitherHeartRightClickedOnBlock!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.COAL_BLOCK.getDefaultState(), 3);
	}
}
