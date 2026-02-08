package bee.weaponry.entity.client;

import bee.weaponry.Weaponry;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.resources.Identifier;

public class AxeProjectileModel extends EntityModel<EntityRenderState> {
    public static final ModelLayerLocation AXE = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Weaponry.MOD_ID, "axe"), "main");
    private final ModelPart axe;
    protected AxeProjectileModel(ModelPart modelPart) {
        super(modelPart);
        this.axe = root.getChild("bb_main");
    }

    public static LayerDefinition getTexturedModelData() {
        MeshDefinition modelData = new MeshDefinition();
        PartDefinition modelPartData = modelData.getRoot();
        PartDefinition bb_main = modelPartData.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(-18, -16).addBox(0.0F, -16.0F, -8.0F, 1.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.rotation(0.0F, 24.0F, 0.0F));
        return LayerDefinition.create(modelData, 16, 16);
    }
}
