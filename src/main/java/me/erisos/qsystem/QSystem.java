package me.erisos.qsystem;

import me.erisos.qsystem.commands.*;
import me.erisos.qsystem.entity.EntityEvents;
import me.erisos.qsystem.listeners.*;
import me.erisos.qsystem.loops.QAutoCommands;
import org.bukkit.plugin.java.JavaPlugin;

public class QSystem extends JavaPlugin {

    private static long SERVER_START_TIME;

    @Override
    public void onEnable() {
        SERVER_START_TIME = System.currentTimeMillis();

        this.saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new QCommandEvent(this), this);
        getServer().getPluginManager().registerEvents(new QSpawnEvent(this), this);
        getServer().getPluginManager().registerEvents(new QVoidSpawn(this), this);
        getServer().getPluginManager().registerEvents(new QJoinTitle(this), this);
        getServer().getPluginManager().registerEvents(new QChatEvent(this), this);
        getServer().getPluginManager().registerEvents(new QInteractiveBlocks(this), this);
        getServer().getPluginManager().registerEvents(new QJoinLeaveBoolean(this), this);

        new EntityEvents(this);
        new QAutoCommands(this);

        getCommand("qSetSpawn").setExecutor(new QSetSpawn(this));
        getCommand("spawn").setExecutor(new QSpawn(this));
        getCommand("qDefaultPlayerEffect").setExecutor(new QCommands(this));
        getCommand("discord").setExecutor(new QDiscord(this));
    }

    public static long getServerStartTime() {
        return SERVER_START_TIME;
    }
}