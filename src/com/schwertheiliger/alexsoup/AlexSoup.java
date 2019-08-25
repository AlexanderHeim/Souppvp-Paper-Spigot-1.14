package com.schwertheiliger.alexsoup;

import org.bukkit.plugin.java.JavaPlugin;

public class AlexSoup extends JavaPlugin{

	public static AlexSoup instance;
	
	public void onEnable() {
		instance = this;
		SoupManager.registerSoups();
	}
}
