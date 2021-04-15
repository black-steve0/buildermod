
package net.mcreator.buildermod.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;
import net.minecraft.block.material.PushReaction;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.buildermod.procedures.EatherportalEntityWalksOnTheBlockProcedure;
import net.mcreator.buildermod.BuildermodModElements;

import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;

@BuildermodModElements.ModElement.Tag
public class EatherportalBlock extends BuildermodModElements.ModElement {
	@ObjectHolder("buildermod:eatherportal")
	public static final Block block = null;
	public EatherportalBlock(BuildermodModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(null)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends SlabBlock {
		public CustomBlock() {
			super(Block.Properties.create(Material.BARRIER).sound(SoundType.BONE).hardnessAndResistance(1f, 10f).setLightLevel(s -> 15)
					.setNeedsPostProcessing((bs, br, bp) -> true).setEmmisiveRendering((bs, br, bp) -> true));
			setRegistryName("eatherportal");
		}

		@Override
		public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
			return new ItemStack(Blocks.AIR, (int) (1));
		}

		@Override
		public PathNodeType getAiPathNodeType(BlockState state, IBlockReader world, BlockPos pos, MobEntity entity) {
			return PathNodeType.WALKABLE;
		}

		@Override
		public PushReaction getPushReaction(BlockState state) {
			return PushReaction.DESTROY;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(Blocks.AIR, (int) (1)));
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
			super.animateTick(state, world, pos, random);
			PlayerEntity entity = Minecraft.getInstance().player;
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			if (true)
				for (int l = 0; l < 3; ++l) {
					double d0 = (double) ((float) x + 0.5) + (double) (random.nextFloat() - 0.5) * 0.5D;
					double d1 = ((double) ((float) y + 0.7) + (double) (random.nextFloat() - 0.5) * 0.5D) + 0.5;
					double d2 = (double) ((float) z + 0.5) + (double) (random.nextFloat() - 0.5) * 0.5D;
					world.addParticle(ParticleTypes.WHITE_ASH, d0, d1, d2, 0, 0, 0);
				}
		}

		@Override
		public void onEntityWalk(World world, BlockPos pos, Entity entity) {
			super.onEntityWalk(world, pos, entity);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				EatherportalEntityWalksOnTheBlockProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
