package net.mcreator.buildermod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.buildermod.item.ManahelmetItem;
import net.mcreator.buildermod.enchantment.WiseEnchantment;
import net.mcreator.buildermod.BuildermodModElements;
import net.mcreator.buildermod.BuildermodMod;

import java.util.Map;
import java.util.HashMap;

@BuildermodModElements.ModElement.Tag
public class ManahelmetHelmetTickEventProcedure extends BuildermodModElements.ModElement {
	public ManahelmetHelmetTickEventProcedure(BuildermodModElements instance) {
		super(instance, 56);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BuildermodMod.LOGGER.warn("Failed to load dependency entity for procedure ManahelmetHelmetTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double MaxCharge = 0;
		if ((new ItemStack(ManahelmetItem.helmet, (int) (1)).getItem() == ((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
				: ItemStack.EMPTY).getItem())) {
			MaxCharge = (double) 125;
			if (((EnchantmentHelper.getEnchantmentLevel(WiseEnchantment.enchantment,
					((entity instanceof LivingEntity)
							? ((LivingEntity) entity)
									.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
							: ItemStack.EMPTY)) != 0))) {
				MaxCharge = (double) (((EnchantmentHelper.getEnchantmentLevel(WiseEnchantment.enchantment,
						((entity instanceof LivingEntity)
								? ((LivingEntity) entity)
										.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
								: ItemStack.EMPTY)))
						* 50) + 125);
			}
			if (((MaxCharge) > (entity.getPersistentData().getDouble("Charge")))) {
				entity.getPersistentData().putDouble("Charge", (1 + (entity.getPersistentData().getDouble("Charge"))));
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
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
}
