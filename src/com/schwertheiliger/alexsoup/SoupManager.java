package com.schwertheiliger.alexsoup;

import org.bukkit.Bukkit;

public class SoupManager {

	public static void registerSoups() {
		Bukkit.getPluginManager().registerEvents(new MushroomStew(), AlexSoup.instance);
	}
}
