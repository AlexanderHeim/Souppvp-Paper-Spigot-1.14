package com.schwertheiliger.alexsoup;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MushroomStew extends Soup{

	public MushroomStew() {
		super(new ItemStack(Material.MUSHROOM_STEW).getItemMeta().getDisplayName(), Material.MUSHROOM_STEW, 7, 7, 
			  new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20*3, 1));
	}
	
	@EventHandler
	public void onRightClick(PlayerInteractEvent e) {
		super.eatSoup(e.getPlayer());
	}
	
	

}
