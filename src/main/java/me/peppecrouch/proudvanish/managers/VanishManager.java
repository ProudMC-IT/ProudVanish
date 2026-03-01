package me.peppecrouch.proudvanish.managers;

import me.peppecrouch.proudvanish.ProudVanish;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class VanishManager {

    private final ProudVanish plugin;
    private final Set<UUID> vanishedPlayers = new HashSet<>();

    public VanishManager(ProudVanish plugin) {
        this.plugin = plugin;
    }

    public boolean isVanished(UUID uuid) {
        return vanishedPlayers.contains(uuid);
    }

    public boolean isVanished(Player player) {
        return vanishedPlayers.contains(player.getUniqueId());
    }

    public void set(Player player) {
        if (isVanished(player)) return;
        vanishedPlayers.add(player.getUniqueId());
        player.sendMessage(plugin.getMessage("vanished"));
        for (Player online : Bukkit.getOnlinePlayers()) {
            online.hidePlayer(player);
        }
    }
    public void unset(Player player) {
        if (!isVanished(player)) return;
        vanishedPlayers.remove(player.getUniqueId());
        player.sendMessage(plugin.getMessage("unvanished"));
        for (Player online : Bukkit.getOnlinePlayers()) {
            online.showPlayer(player);
        }
    }

    public void toggle(Player player) {
        if (isVanished(player)) {
            unset(player);
        }
        else {
            set(player);
        }
    }

    public ItemStack vanish(ItemStack itemStack, ItemMeta meta) {

    }

    public void itemVanish(Player player) {

    }
    public ItemStack unvanish(ItemSta) {

    }

}
