package bee.weaponry.mixin;

import bee.weaponry.registry.ModItems;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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
	private void init(Entity entity, CallbackInfo ci) {

		if (this.getWeaponItem().is(ModItems.WEAPONTEST)) {
			Vec3 rotation = ((Player)(Object)this).getViewVector(1).reverse().scale(0.4);
			entity.setDeltaMovement(rotation.x(), rotation.y(), rotation.z());
		}

	}
}