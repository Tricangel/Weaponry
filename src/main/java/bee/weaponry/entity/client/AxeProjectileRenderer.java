package bee.weaponry.entity.client;

import bee.weaponry.entity.AxeEntity;
import net.minecraft.client.model.object.projectile.ArrowModel;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

public class AxeProjectileRenderer extends EntityRenderer<AxeEntity, EntityRenderState> {
    protected AxeProjectileModel model;
    public AxeProjectileRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new AxeProjectileModel(context.bakeLayer(AxeProjectileModel.AXE));

    }

    @Override
    public EntityRenderState createRenderState() {
        return new EntityRenderState();
    }
}
