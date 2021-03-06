package com.github.games647.scoreboardstats.commands;

import com.github.games647.scoreboardstats.Language;
import com.github.games647.scoreboardstats.ScoreboardStats;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Handle the Reload command for the plugin.
 */
public class ReloadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, final String label, final String[] args) {
        if (!commandSender.hasPermission("scoreboardstats.reload")) {
            commandSender.sendMessage(Language.get("noPermission"));
            return true;
        }
        
        ScoreboardStats.getInstance().onReload();
        commandSender.sendMessage(Language.get("onReload"));
        return true;
    }
}
