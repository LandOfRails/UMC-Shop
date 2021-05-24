package net.landofrails.umcshop.content.items;

import cam72cam.mod.render.ItemRender;

public class CustomItems {

	public static final ItemSmallShop ITEMSMALLSHOP = new ItemSmallShop();

	public static void register(boolean client) {
		if (client) {
			ItemRender.register(ITEMSMALLSHOP, ItemSmallShop.getModelFor());
		}
	}

}
