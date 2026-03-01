package me.peppecrouch.proudvanish.commands;

import me.peppecrouch.proudvanish.ProudVanish;
import me.peppecrouch.proudvanish.managers.VanishManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public class VanishCommand implements CommandExecutor {

    private final ProudVanish plugin;
    private final VanishManager vanishManager;

    public VanishCommand(ProudVanish plugin, VanishManager vanishManager) {
        this.plugin = plugin;
        this.vanishManager = vanishManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(plugin.getConfig().getString("only-player"));
            return true;
        }
        if (args.length == 0) {
            player.sendMessage(plugin.getMessage("no-args"));
            return true;
        }
        switch (args[0].toLowerCase()) {
            case "item" -> vanishManager.item(player);
            case "toggle" -> vanishManager.toggle(player);
            case "on" -> vanishManager.set(player);
            case "off" -> vanishManager.unset(player);
            default -> player.sendMessage(plugin.getMessage("unknown-command"));
        };
        return true;
    }
}
