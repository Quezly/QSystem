package me.erisos.qsystem.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class QCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if(player.hasPermission("qsystem.admin")) {

                player.setWalkSpeed(0.2f);
                player.setFlySpeed(0.2f);
                player.setGameMode(GameMode.CREATIVE);
                player.setFoodLevel(20);
                player.removePotionEffect(PotionEffectType.INVISIBILITY);
            }
        }

        return false;
    }
}
