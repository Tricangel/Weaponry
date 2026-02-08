package bee.weaponry.registry;

import bee.weaponry.Weaponry;
import bee.weaponry.entity.AxeEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {

    private static final ResourceKey<EntityType<?>> AXE_KEY =
            ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(Weaponry.MOD_ID, "axe"));


    public static final EntityType<AxeEntity> AXE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(Weaponry.MOD_ID, "axe"),
            EntityType.Builder.
                    of(AxeEntity::new, MobCategory.MISC)
                    .sized(0.5f, 1.15f)
                    .build(AXE_KEY));


    public static void init() {}
}
