package net.landofrails.umcshop.content.blocks.entities;

import org.lwjgl.opengl.GL11;

import cam72cam.mod.ModCore;
import cam72cam.mod.block.BlockEntity;
import cam72cam.mod.item.ItemStack;
import cam72cam.mod.model.obj.OBJModel;
import cam72cam.mod.render.OpenGL;
import cam72cam.mod.render.StandardModel;
import cam72cam.mod.render.obj.OBJRender;
import cam72cam.mod.resource.Identifier;
import net.landofrails.umcshop.UMCShop;
import net.landofrails.umcshop.content.items.CustomItems;

public class BlockEntitySmallShop extends BlockEntity {

	private float rotation = 0;
	private OBJModel model;
	private OBJRender renderer;

	public BlockEntitySmallShop() {
		Identifier id = new Identifier(UMCShop.MODID, "models/block/smallshopblock/smallshopblock.obj");
		try {
			model = new OBJModel(id, 0);
			renderer = new OBJRender(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ItemStack onPick() {
		return new ItemStack(CustomItems.ITEMSMALLSHOP, 1);
	}

	public static StandardModel render(BlockEntitySmallShop entity) {
		return new StandardModel().addCustom(partialTicks -> renderStuff(entity, partialTicks));
	}

	private static void renderStuff(BlockEntitySmallShop entity, float partialTicks) {

		float[] translation = new float[]{0f, 0f, 0f};
		float[] rotation = new float[]{0f, 0f, 0f};

		try {
			if (entity.getRenderer() == null || entity.getModel() == null) {
				ModCore.warn("Block has no renderer: %s!", entity.getPos().toString());
				return;
			}
			try (OpenGL.With matrix = OpenGL.matrix(); OpenGL.With tex = entity.getRenderer().bindTexture()) {
				GL11.glTranslated(translation[0], translation[1], translation[2]);

				GL11.glRotated(rotation[0], 1, 0, 0);
				GL11.glRotated(entity.getBlockRotation() + rotation[1], 0, 1, 0);
				GL11.glRotated(rotation[2], 0, 0, 1);

				entity.getRenderer().draw();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public OBJModel getModel() {
		return model;
	}

	public OBJRender getRenderer() {
		return renderer;
	}

	public float getBlockRotation() {
		return rotation;
	}

	public void setBlockRotation(float rotation) {
		this.rotation = rotation;
	}

}
