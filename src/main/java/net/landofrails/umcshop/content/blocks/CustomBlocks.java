package net.landofrails.umcshop.content.blocks;

import cam72cam.mod.render.BlockRender;
import net.landofrails.umcshop.content.blocks.entities.BlockEntitySmallShop;

public class CustomBlocks {
	
	public static final BlockSmallShop BLOCKSMALLSHOP = new BlockSmallShop();
	
	public static void register() {
		BlockRender.register(BLOCKSMALLSHOP, BlockEntitySmallShop::render, BlockEntitySmallShop.class);
	}
	
}
