package me.erisos.qsystem.loops;

import me.erisos.qsystem.QSystem;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Despical
 */
public class QAutoCommands {

    private final List<CustomTime> times;

    public QAutoCommands(QSystem plugin) {
        this.times = new ArrayList<>();

        var config = plugin.getConfig();

        if (!config.getBoolean("time_loop")) return;

        var section = config.getConfigurationSection("time_loops");

        if (section == null) {
            plugin.getLogger().warning("''time_loops'' section is not found in config.yml!");
            return;
        }

        for (final var key : section.getKeys(false)) {
            int hours = section.getInt(key + ".hour");
            var minutes = section.getInt(key + ".minutes");
            var message = section.getString(key + ".message");
            var perm = section.getString(key + ".message_perm");
            var commands = section.getStringList(key + ".commands");
            var customTime = new CustomTime(hours, minutes, message, perm, commands);

            this.times.add(customTime);
        }

        LocalTime localTime = LocalTime.now();

        plugin.getServer().getScheduler().runTaskTimer(plugin, () -> {
            int hours = localTime.getHour(), minutes = localTime.getMinute();

            times.stream().filter(time -> time.hours == hours && time.minutes == minutes).forEach(time -> {
                time.commands.forEach(cmd -> plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), cmd));

                plugin.getServer().getOnlinePlayers().stream().filter(player -> player.hasPermission(time.messagePerm)).forEach(player -> player.sendMessage(time.message));
            });
        }, 0L, 1200L);
    }

    public record CustomTime(int hours, int minutes, String message, String messagePerm, List<String> commands) {
    }
}