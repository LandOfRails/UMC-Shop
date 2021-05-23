package net.landofrails.umcshop.content.items;

import java.util.Arrays;
import java.util.List;

import org.lwjgl.opengl.GL11;

import cam72cam.mod.block.BlockTypeEntity;
import cam72cam.mod.entity.Player;
import cam72cam.mod.entity.Player.Hand;
import cam72cam.mod.item.ClickResult;
import cam72cam.mod.item.CreativeTab;
import cam72cam.mod.item.CustomItem;
import cam72cam.mod.item.ItemStack;
import cam72cam.mod.math.Vec3d;
import cam72cam.mod.math.Vec3i;
import cam72cam.mod.model.obj.OBJModel;
import cam72cam.mod.render.ItemRender;
import cam72cam.mod.render.OpenGL;
import cam72cam.mod.render.StandardModel;
import cam72cam.mod.render.obj.OBJRender;
import cam72cam.mod.resource.Identifier;
import cam72cam.mod.util.Facing;
import cam72cam.mod.world.World;
import net.landofrails.umcshop.UMCShop;
import net.landofrails.umcshop.content.blocks.CustomBlocks;
import net.landofrails.umcshop.content.blocks.entities.BlockEntitySmallShop;
import net.landofrails.umcshop.content.creativetabs.CustomTabs;

public class ItemSmallShop extends CustomItem {

	private OBJModel model;
	private OBJRender renderer;

	public ItemSmallShop() {
		super(UMCShop.MODID, "smallshop");
		try {
			Identifier id = new Identifier(UMCShop.MODID, "models/item/smallshopblock.obj");
			model = new OBJModel(id, 0);
			renderer = new OBJRender(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void init() {
		if (model == null) {
			try {
				Identifier id = new Identifier(UMCShop.MODID, "models/item/smallshopblock.obj");
				model = new OBJModel(id, 0);
				renderer = new OBJRender(model);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<CreativeTab> getCreativeTabs() {
		return Arrays.asList(CustomTabs.shopTab);
	}


	@Override
	public List<String> getTooltip(ItemStack itemStack) {
		String lore = "Small Shop";
		return Arrays.asList(lore);
	}


	@Override
	public ClickResult onClickBlock(Player player, World world, Vec3i pos, Hand hand, Facing facing, Vec3d inBlockPos) {
		Vec3i target = world.isReplaceable(pos) ? pos : pos.offset(facing);

		if (isStandingInBlock(player.getBlockPosition().subtract(target)))
			return ClickResult.REJECTED;

		if (world.isAir(target) || world.isReplaceable(target)) {

			BlockTypeEntity block = CustomBlocks.BLOCKSMALLSHOP;

			world.setBlock(target, block);
			BlockEntitySmallShop blockEntity = world.getBlockEntity(target, BlockEntitySmallShop.class);
			if (blockEntity != null) {
				blockEntity.setBlockRotation(player.getRotationYawHead());
			}

			return ClickResult.ACCEPTED;
		}

		return ClickResult.REJECTED;
	}

	private boolean isStandingInBlock(Vec3i vec3i) {
		return vec3i.x == 0 && vec3i.z == 0 && (vec3i.y == 0 || vec3i.y == -1);
	}

	// Rendering
	public static ItemRender.IItemModel getModelFor() {
		return (world, stack) -> new StandardModel().addCustom(() -> {

			CustomItems.ITEMSMALLSHOP.init();

			float[] translate = new float[]{0f, 0f, 0f};
			float[] rotation = new float[]{0f, 0f, 0f};
			float scale = 0f;
			try (OpenGL.With ignored = OpenGL.matrix(); OpenGL.With ignored1 = CustomItems.ITEMSMALLSHOP.renderer.bindTexture()) {
				GL11.glTranslated(translate[0], translate[1], translate[2]);
				GL11.glRotatef(rotation[0], 1, 0, 0);
				GL11.glRotatef(rotation[1], 0, 1, 0);
				GL11.glRotatef(rotation[2], 0, 0, 1);
				GL11.glScaled(scale, scale, scale);
				CustomItems.ITEMSMALLSHOP.renderer.draw();
			}
		});
	}

}
