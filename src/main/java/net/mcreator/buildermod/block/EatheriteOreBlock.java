
package net.mcreator.buildermod.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.buildermod.item.EatheriteItem;
import net.mcreator.buildermod.BuildermodModElements;

import java.util.List;
import java.util.Collections;

@BuildermodModElements.ModElement.Tag
public class EatheriteOreBlock extends BuildermodModElements.ModElement {
	@ObjectHolder("buildermod:eatherite_ore")
	public static final Block block = null;
	public EatheriteOreBlock(BuildermodModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(5f, 50f).setLightLevel(s -> 0).harvestLevel(3)
					.harvestTool(ToolType.PICKAXE).setRequiresTool());
			setRegistryName("eatherite_ore");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(EatheriteItem.block, (int) (1)));
		}
	}
}
