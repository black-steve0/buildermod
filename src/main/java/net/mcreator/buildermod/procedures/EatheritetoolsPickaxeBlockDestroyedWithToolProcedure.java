package net.mcreator.buildermod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.buildermod.item.Eatherite_toolsPickaxeItem;
import net.mcreator.buildermod.BuildermodModElements;
import net.mcreator.buildermod.BuildermodMod;

import java.util.Map;
import java.util.HashMap;

@BuildermodModElements.ModElement.Tag
public class EatheritetoolsPickaxeBlockDestroyedWithToolProcedure extends BuildermodModElements.ModElement {
	public EatheritetoolsPickaxeBlockDestroyedWithToolProcedure(BuildermodModElements instance) {
		super(instance, 19);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BuildermodMod.LOGGER.warn("Failed to load dependency entity for procedure EatheritetoolsPickaxeBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BuildermodMod.LOGGER.warn("Failed to load dependency world for procedure EatheritetoolsPickaxeBlockDestroyedWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		double X = 0;
		double Y = 0;
		double Z = 0;
		if ((new ItemStack(Eatherite_toolsPickaxeItem.block, (int) (1))
				.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())) {
			X = (double) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
					entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX());
			Y = (double) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
					entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY());
			Z = (double) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
					entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ());
			if ((Blocks.DIAMOND_ORE.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) (X), (int) (Y), (int) (Z))))
					.getBlock())) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(
							(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getItem(),
							(int) 30);
				if (((Blocks.CAVE_AIR.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) (X), (int) (Y), (int) (Z)))).getBlock())
						|| (Blocks.AIR.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) (X), (int) (Y), (int) (Z))))
								.getBlock()))) {
					world.setBlockState(new BlockPos((int) (X), (int) (Y), (int) (Z)), Blocks.DIAMOND_BLOCK.getDefaultState(), 3);
				}
			}
		}
	}

	@SubscribeEvent
	public void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
		PlayerEntity entity = event.getPlayer();
		if (event.getHand() != entity.getActiveHand()) {
			return;
		}
		double i = event.getPos().getX();
		double j = event.getPos().getY();
		double k = event.getPos().getZ();
		IWorld world = event.getWorld();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
