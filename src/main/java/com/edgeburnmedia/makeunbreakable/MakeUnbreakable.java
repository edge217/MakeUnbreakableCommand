/*
 * Copyright (c) 2023 Edgeburn Media. All rights reserved.
 */

package com.edgeburnmedia.makeunbreakable;

import org.bukkit.plugin.java.JavaPlugin;

public final class MakeUnbreakable extends JavaPlugin {

	@Override
	public void onEnable() {
		getCommand("makeunbreakable").setExecutor(new MakeUnbreakableCommand());
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
}
