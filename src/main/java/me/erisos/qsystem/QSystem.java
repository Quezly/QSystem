package me.erisos.qsystem;

import me.erisos.qsystem.commands.QCommands;
import me.erisos.qsystem.commands.QDiscord;
import me.erisos.qsystem.commands.QSetSpawn;
import me.erisos.qsystem.commands.QSpawn;
import me.erisos.qsystem.entity.EntityEvents;
import me.erisos.qsystem.listeners.*;
import org.bukkit.plugin.java.JavaPlugin;

public class QSystem extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new QJoinEvent(this), this);
        getServer().getPluginManager().registerEvents(new QCommandEvent(this), this);
        getServer().getPluginManager().registerEvents(new QExitEvent(this), this);
        getServer().getPluginManager().registerEvents(new QSpawnEvent(this), this);
        getServer().getPluginManager().registerEvents(new QVoidSpawn(this), this);
        getServer().getPluginManager().registerEvents(new QJoinTitle(this), this);
        getServer().getPluginManager().registerEvents(new QChatEvent(this), this);

        new EntityEvents(this);

        getCommand("qSetSpawn").setExecutor(new QSetSpawn(this));
        getCommand("spawn").setExecutor(new QSpawn(this));
        getCommand("qDefaultPlayerEffect").setExecutor(new QCommands(this));
        getCommand("discord").setExecutor(new QDiscord(this));
    }
}