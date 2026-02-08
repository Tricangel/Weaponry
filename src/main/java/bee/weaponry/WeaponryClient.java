package bee.weaponry;

import bee.weaponry.entity.client.AxeProjectileModel;
import bee.weaponry.entity.client.AxeProjectileRenderer;
import bee.weaponry.registry.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class WeaponryClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(AxeProjectileModel.AXE, AxeProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.AXE, AxeProjectileRenderer::new);
    }
}
