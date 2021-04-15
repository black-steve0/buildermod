
package net.mcreator.buildermod.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import net.mcreator.buildermod.BuildermodModElements;

@BuildermodModElements.ModElement.Tag
public class SupremesharpnessEnchantment extends BuildermodModElements.ModElement {
	@ObjectHolder("buildermod:supremesharpness")
	public static final Enchantment enchantment = null;
	public SupremesharpnessEnchantment(BuildermodModElements instance) {
		super(instance, 20);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("supremesharpness"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.RARE, EnchantmentType.WEAPON, slots);
		}

		@Override
		public int getMinLevel() {
			return 3;
		}

		@Override
		public int getMaxLevel() {
			return 4;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return true;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}
	}
}
