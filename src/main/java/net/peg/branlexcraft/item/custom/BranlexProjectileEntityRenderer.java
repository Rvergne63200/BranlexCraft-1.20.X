package net.peg.branlexcraft.item.custom;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.FlyingItemEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.peg.branlexcraft.BranlexCraft;

public class BranlexProjectileEntityRenderer extends EntityRenderer<BranlexProjectileEntity> {

    public BranlexProjectileEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }


    @Override
    public Identifier getTexture(BranlexProjectileEntity entity) {
        return new Identifier(BranlexCraft.MOD_ID, "textures/entity/branlex_projectile.png");
    }
}
