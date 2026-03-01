package me.peppecrouch.proudvanish;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.stream.Collectors;

public final class ProudVanish extends JavaPlugin {


    @Override
    public void onEnable() {


    }

    public Component getMessage(String key) {

        String message = getConfig().getString("messages." + key).replace("&0", "<black>")
            .replace("&1", "<dark_blue>")
            .replace("&2", "<dark_green>")
            .replace("&3", "<dark_aqua>")
            .replace("&4", "<dark_red>")
            .replace("&5", "<dark_purple>")
            .replace("&6", "<gold>")
            .replace("&7", "<gray>")
            .replace("&8", "<dark_gray>")
            .replace("&9", "<blue>")
            .replace("&a", "<green>")
            .replace("&b", "<aqua>")
            .replace("&c", "<red>")
            .replace("&d", "<light_purple>")
            .replace("&e", "<yellow>")
            .replace("&f", "<white>")
            .replace("&k", "<obf>")
            .replace("&l", "<bold>")
            .replace("&m", "<strikethrough>")
            .replace("&n", "<underlined>")
            .replace("&o", "<italic>")
            .replace("&r", "<reset>");

        return MiniMessage.miniMessage().deserialize(message);

    }

    public ItemStack getItem(String key) {
        Material material = Material.getMaterial(getConfig().getString("items." + key + ".material"));
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(getConfig().getRichMessage("items." + key + ".name"));
        meta.lore(
                getConfig().getStringList("items." + key + ".lore")
                        .stream()
                        .map(line -> MiniMessage.miniMessage().deserialize(line))
                        .toList()
        );
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
