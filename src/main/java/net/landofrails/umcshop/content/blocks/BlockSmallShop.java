package net.landofrails.umcshop.content.blocks;

import cam72cam.mod.block.BlockEntity;
import cam72cam.mod.block.BlockTypeEntity;
import cam72cam.mod.block.Material;
import cam72cam.mod.entity.boundingbox.IBoundingBox;
import cam72cam.mod.math.Vec3i;
import cam72cam.mod.world.World;
import net.landofrails.umcshop.UMCShop;
import net.landofrails.umcshop.content.blocks.entities.BlockEntitySmallShop;

public class BlockSmallShop extends BlockTypeEntity {

	public BlockSmallShop() {
		super(UMCShop.MODID, "smallshop");
	}

	@Override
	protected BlockEntity constructBlockEntity() {
		return new BlockEntitySmallShop();
	}

	@Override
	public boolean isConnectable() {
		return true;
	}

	@Override
	public IBoundingBox getBoundingBox(World world, Vec3i pos) {
		// TODO: Generate BoundingBox
		return super.getBoundingBox(world, pos);
	}

	@Override
	public Material getMaterial() {
		return Material.METAL;
	}

}
