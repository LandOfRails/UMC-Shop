package net.landofrails.umcshop.content.creativetabs;

import cam72cam.mod.item.CreativeTab;
import cam72cam.mod.item.ItemStack;
import net.landofrails.umcshop.UMCShop;
import net.landofrails.umcshop.content.items.CustomItems;

public class CustomTabs {
	
	public static CreativeTab shopTab;
	
	public static void register() {

		shopTab = new CreativeTab(UMCShop.MODID + ".shoptab",
				() -> new ItemStack(CustomItems.ITEMSMALLSHOP, 1));
	}
	
}
