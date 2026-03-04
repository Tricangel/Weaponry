package bee.weaponry.registry;

import bee.weaponry.Weaponry;
import bee.weaponry.component.AmountOfExplosivesComponent;
import bee.weaponry.component.ExplosiveComponent;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.LivingEntity;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentInitializer;

public class ModEntityComponents implements EntityComponentInitializer {
    public static final ComponentKey<ExplosiveComponent> EXPLODETIMER =
            ComponentRegistry.getOrCreate(Identifier.fromNamespaceAndPath(Weaponry.MOD_ID, "explosivetimer"), ExplosiveComponent.class);

    public static final ComponentKey<AmountOfExplosivesComponent> AMOUNT_OF_EXPLOSIVES =
            ComponentRegistry.getOrCreate(Identifier.fromNamespaceAndPath(Weaponry.MOD_ID, "amount_of_explosives"), AmountOfExplosivesComponent.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry entityComponentFactoryRegistry) {
        entityComponentFactoryRegistry.registerFor(LivingEntity.class, EXPLODETIMER, ExplosiveComponent::new);
        entityComponentFactoryRegistry.registerFor(LivingEntity.class, AMOUNT_OF_EXPLOSIVES, amount -> new AmountOfExplosivesComponent());
    }
}
