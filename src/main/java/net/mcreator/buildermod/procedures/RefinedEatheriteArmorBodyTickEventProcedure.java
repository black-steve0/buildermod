package net.mcreator.buildermod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.buildermod.BuildermodModElements;
import net.mcreator.buildermod.BuildermodMod;

import java.util.Map;

@BuildermodModElements.ModElement.Tag
public class RefinedEatheriteArmorBodyTickEventProcedure extends BuildermodModElements.ModElement {
	public RefinedEatheriteArmorBodyTickEventProcedure(BuildermodModElements instance) {
		super(instance, 55);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BuildermodMod.LOGGER.warn("Failed to load dependency entity for procedure RefinedEatheriteArmorBodyTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putDouble("maxMana", (250 + (entity.getPersistentData().getDouble("maxMana"))));
	}
}
