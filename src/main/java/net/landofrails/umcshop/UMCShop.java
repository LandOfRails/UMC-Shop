package net.landofrails.umcshop;

import cam72cam.mod.ModCore;
import cam72cam.mod.ModEvent;
import net.landofrails.umcshop.content.blocks.CustomBlocks;
import net.landofrails.umcshop.content.creativetabs.CustomTabs;
import net.landofrails.umcshop.content.items.CustomItems;

public class UMCShop extends ModCore.Mod {
	@SuppressWarnings("java:S1845")
	public static final String MODID = "umcshop";
	public static final String VERSION = "0.0.1";

	@Override
	public String modID() {
		return MODID;
	}

	@Override
	public void commonEvent(ModEvent event) {
		switch (event) {
			case CONSTRUCT :
				break;
			case INITIALIZE :
				CustomTabs.register();
				CustomItems.register();
				CustomBlocks.register();
				break;
			case SETUP :
				break;
			case FINALIZE :
				break;
			case START :
				break;
			case RELOAD :
				break;
		}

	}

	@Override
	public void clientEvent(ModEvent event) {
		switch (event) {
			case CONSTRUCT :
				break;
			case INITIALIZE :
				break;
			case SETUP :
				break;
			case FINALIZE :
				break;
			case START :
				break;
			case RELOAD :
				break;
		}

	}

	@Override
	public void serverEvent(ModEvent event) {
		switch (event) {
			case CONSTRUCT :
				break;
			case INITIALIZE :
				break;
			case SETUP :
				break;
			case FINALIZE :
				break;
			case START :
				break;
			case RELOAD :
				break;
		}

	}
}
