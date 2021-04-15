
package net.mcreator.buildermod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.buildermod.BuildermodModElements;

@BuildermodModElements.ModElement.Tag
public class Eatherite_toolsShovelItem extends BuildermodModElements.ModElement {
	@ObjectHolder("buildermod:eatherite_tools_shovel")
	public static final Item block = null;
	public Eatherite_toolsShovelItem(BuildermodModElements instance) {
		super(instance, 12);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
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
				return Ingredient.fromStacks(new ItemStack(EatheriteItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("eatherite_tools_shovel"));
	}
}
