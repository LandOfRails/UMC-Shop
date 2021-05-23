package net.landofrails.umcshop;

import cam72cam.mod.ModCore;

@net.minecraftforge.fml.common.Mod(modid = UMCShop.MODID, name = "UMC Shop", version = UMCShop.VERSION, dependencies = "required-after:universalmodcore@[1.0,1.1)", acceptedMinecraftVersions = "[1.12,1.13)")
public class Mod {

	public Mod() {
		// Has to be public
	}

    static {
        try {
			ModCore.register(new net.landofrails.umcshop.UMCShop());
        } catch (Exception e) {
			throw new RuntimeException("Could not load mod " + UMCShop.MODID, e);
        }
    }
}
