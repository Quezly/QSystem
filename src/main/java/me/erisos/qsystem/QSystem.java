package me.erisos.qsystem;

import me.erisos.qsystem.commands.QCommands;
import me.erisos.qsystem.commands.QSetSpawn;
import me.erisos.qsystem.commands.QSpawn;
import me.erisos.qsystem.listeners.QCommandEvent;
import me.erisos.qsystem.listeners.QExitEvent;
import me.erisos.qsystem.listeners.QJoinEvent;
import me.erisos.qsystem.listeners.QSpawnEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.Enumeration;

import org.json.JSONException;
import org.json.JSONObject;

public class QSystem extends JavaPlugin {


    @Override
    public void onEnable() {

        Bukkit.getPluginManager().registerEvents(new QJoinEvent(this), this);
        Bukkit.getPluginManager().registerEvents(new QCommandEvent(this),this);
        Bukkit.getPluginManager().registerEvents(new QExitEvent(this),this);
        Bukkit.getPluginManager().registerEvents(new QSpawnEvent(this), this);

        getCommand("qSpawn").setExecutor(new QSpawn(this));
        getCommand("qSetSpawn").setExecutor(new QSetSpawn(this));

        getCommand("qDefaultplayer").setExecutor(new QCommands());

        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    
}
