
package net.mcreator.buildermod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.buildermod.item.EatheriteItem;
import net.mcreator.buildermod.BuildermodModElements;

@BuildermodModElements.ModElement.Tag
public class BuilderModItemGroup extends BuildermodModElements.ModElement {
	public BuilderModItemGroup(BuildermodModElements instance) {
		super(instance, 22);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabbuilder_mod") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(EatheriteItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
