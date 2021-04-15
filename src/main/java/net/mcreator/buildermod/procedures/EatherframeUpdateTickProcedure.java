package net.mcreator.buildermod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.EntityType;

import net.mcreator.buildermod.block.HolywaterBlock;
import net.mcreator.buildermod.block.EatherportalBlock;
import net.mcreator.buildermod.block.EatherframeBlock;
import net.mcreator.buildermod.BuildermodModElements;
import net.mcreator.buildermod.BuildermodMod;

import java.util.Map;

@BuildermodModElements.ModElement.Tag
public class EatherframeUpdateTickProcedure extends BuildermodModElements.ModElement {
	public EatherframeUpdateTickProcedure(BuildermodModElements instance) {
		super(instance, 4);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BuildermodMod.LOGGER.warn("Failed to load dependency x for procedure EatherframeUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BuildermodMod.LOGGER.warn("Failed to load dependency y for procedure EatherframeUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BuildermodMod.LOGGER.warn("Failed to load dependency z for procedure EatherframeUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BuildermodMod.LOGGER.warn("Failed to load dependency world for procedure EatherframeUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == EatherframeBlock.block.getDefaultState().getBlock())
				&& (((world.getBlockState(new BlockPos((int) (x + 2), (int) y, (int) z))).getBlock() == EatherframeBlock.block.getDefaultState()
						.getBlock())
						&& (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1)))).getBlock() == EatherframeBlock.block
								.getDefaultState().getBlock())
								&& (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z - 1)))).getBlock() == EatherframeBlock.block
										.getDefaultState().getBlock())
										&& ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == HolywaterBlock.block
												.getDefaultState().getBlock())))))) {
			if (world instanceof ServerWorld) {
				LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
				_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x + 1), (int) y, (int) z)));
				_ent.setEffectOnly(false);
				((World) world).addEntity(_ent);
			}
			world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), EatherportalBlock.block.getDefaultState(), 3);
		}
	}
}
