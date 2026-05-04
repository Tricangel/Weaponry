package bee.weaponry.mixin;

import bee.weaponry.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public abstract class ExampleMixin {


	@Shadow
	public abstract ItemStack getWeaponItem();

	@Inject(at = @At("TAIL"), method = "attack")
	private void ticker(Entity entity, CallbackInfo ci) {

		if (this.getWeaponItem().is(ModItems.BATTLE_AXE_PULLBACK)) {
			Player player = (Player) (Object) this;
			float strength = 1f;
			if (entity instanceof LivingEntity livingEntity) {
				strength = (float) (.25f * (1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE)));
			}
			entity.setDeltaMovement(player.position().subtract(entity.position()).scale(strength));
		}


	}



}