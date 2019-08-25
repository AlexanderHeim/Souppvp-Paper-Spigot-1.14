package com.schwertheiliger.alexsoup;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class Soup implements Listener{

	private Material material;
	private String name;
	private double healAmount;
	private int foodAmount;
	private ArrayList<PotionEffect> effects = new ArrayList<PotionEffect>();
	
	public Soup(String name, Material material, double heal, int food, PotionEffect... effects_) {
		this.material = material;
		this.name = name;
		this.healAmount = heal;
		this.foodAmount = food;
		for(PotionEffect effect : effects_) {
			this.effects.add(effect);
		}
	}
	
	protected boolean isSoupInHand(Player player) {
		ItemStack item = player.getInventory().getItemInMainHand();
		if(item.getType() == material && item.getItemMeta().getDisplayName() == name) {
			return true;
		}
		return false;
	}
	
	protected void addHealth(Player player, double amount) {
		if(player.getHealth() + amount > player.getHealthScale()) {
			player.setHealth(player.getHealthScale());
			return;
		}
		player.setHealth(player.getHealth() + amount);
	}
	
	protected void addFoodLevel(Player player, int amount) {
		if(player.getFoodLevel() == 20) return;
		
		if(20 - player.getFoodLevel() <= amount) {
			player.setFoodLevel(20);
			return;
		}
		
		player.setFoodLevel(player.getFoodLevel() + amount);
	}
	
	protected void giveEffects(Player player) {
		for(PotionEffect effect : effects) {
			player.addPotionEffect(effect);
		}
	}
	
	protected void eatSoup(Player player) {
		if(!isSoupInHand(player)) return;
		
		if(player.getHealthScale() - player.getHealth() > 0.2) {
			player.getInventory().setItemInMainHand(new ItemStack(Material.BOWL));
			giveEffects(player);
			addHealth(player, this.healAmount);
			return;
		}
		
		if(player.getFoodLevel() < 20) {
			player.getInventory().setItemInMainHand(new ItemStack(Material.BOWL));
			addFoodLevel(player, this.foodAmount);
			giveEffects(player);
		}
	}
}
