/*
 * Copyright (c) 2023 Edgeburn Media. All rights reserved.
 */

package com.edgeburnmedia.makeunbreakable;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MakeUnbreakableCommand implements CommandExecutor {


	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player player) {
			if (player.getInventory().getItemInMainHand().getType().isAir()) {
				player.sendMessage(
					ChatColor.RED + "You must be holding an item to make it unbreakable!");
				return true;
			} else {
				ItemStack item = player.getInventory().getItemInMainHand();
				ItemMeta meta = item.getItemMeta();
				if (meta != null) {
					meta.setUnbreakable(true);
					item.setItemMeta(meta);
				} else {
					player.sendMessage(ChatColor.RED + "Item meta is null!");
					return true;
				}
				player.sendMessage(ChatColor.GREEN + "Item is now unbreakable!");
				return true;
			}
		} else {
			sender.sendMessage(ChatColor.RED + "You must be a player to use this command!");
			return true;
		}
	}
}
