package me.erisos.qsystem;

import me.erisos.qsystem.commands.QCommands;
import me.erisos.qsystem.commands.QDiscord;
import me.erisos.qsystem.commands.QSetSpawn;
import me.erisos.qsystem.commands.QSpawn;
import me.erisos.qsystem.entity.Enderman;
import me.erisos.qsystem.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class QSystem extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new QJoinEvent(this), this);
        Bukkit.getPluginManager().registerEvents(new QCommandEvent(this), this);
        Bukkit.getPluginManager().registerEvents(new QExitEvent(this), this);
        Bukkit.getPluginManager().registerEvents(new QSpawnEvent(this), this);
        Bukkit.getPluginManager().registerEvents(new QVoidSpawn(this), this);
        Bukkit.getPluginManager().registerEvents(new QJoinTitle(this), this);
        Bukkit.getPluginManager().registerEvents(new QChatEvent(this), this);
        Bukkit.getPluginManager().registerEvents(new Enderman(this), this);
        this.getCommand("qSetSpawn").setExecutor(new QSetSpawn(this));
        this.getCommand("spawn").setExecutor(new QSpawn(this));
        this.getCommand("qDefaultPlayerEffect").setExecutor(new QCommands(this));
        this.getCommand("discord").setExecutor(new QDiscord(this));
        this.saveDefaultConfig();
    }
}