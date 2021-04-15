
package net.mcreator.buildermod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.buildermod.procedures.EatheritetoolsPickaxeBlockDestroyedWithToolProcedure;
import net.mcreator.buildermod.BuildermodModElements;

import java.util.Map;
import java.util.HashMap;

@BuildermodModElements.ModElement.Tag
public class Eatherite_toolsPickaxeItem extends BuildermodModElements.ModElement {
	@ObjectHolder("buildermod:eatherite_tools_pickaxe")
	public static final Item block = null;
	public Eatherite_toolsPickaxeItem(BuildermodModElements instance) {
		super(instance, 9);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 2380;
			}

			public float getEfficiency() {
				return 16f;
			}

			public float getAttackDamage() {
				return 8f;
			}

			public int getHarvestLevel() {
				return 10;
			}

			public int getEnchantability() {
				return 70;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(EatheriteItem.block, (int) (1)), new ItemStack(Items.NETHER_STAR, (int) (1)),
						new ItemStack(Blocks.END_STONE, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {
			@Override
			public boolean onBlockDestroyed(ItemStack itemstack, World world, BlockState bl, BlockPos pos, LivingEntity entity) {
				boolean retval = super.onBlockDestroyed(itemstack, world, bl, pos, entity);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("world", world);
					EatheritetoolsPickaxeBlockDestroyedWithToolProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("eatherite_tools_pickaxe"));
	}
}
