package me.erisos.qsystem.utils;

import net.md_5.bungee.api.ChatColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Txt {

    static public final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";
    public static String parse(String text){
        String[] texts = text.split(String.format(WITH_DELIMITER, "&"));
        StringBuilder finalText = new StringBuilder();
        for (int i = 0; i < texts.length; i++){
            if (texts[i].equalsIgnoreCase("&")){
                //get the next string
                i++;
                if (texts[i].charAt(0) == '#'){
                    finalText.append(ChatColor.valueOf(texts[i].substring(0, 7)) + texts[i].substring(7));
                }else{
                    finalText.append(org.bukkit.ChatColor.translateAlternateColorCodes('&', "&" + texts[i]));
                }
            }else{
                finalText.append(texts[i]);
            }
        }

        return finalText.toString();
    }

    public static List<String> parse(List<String> list) {
        List<String> nList = new ArrayList<>();
        for(String s : list) {
            nList.add(parse(s));
        }
        return nList;
    }

    public static String parseAndReplace(String string, String... replacements) {
        if(replacements.length > 0) {
            Iterator<String> iterator = Arrays.asList(replacements).iterator();

            while(iterator.hasNext()) {
                String key = iterator.next();

                if(iterator.hasNext()) {
                    String value = iterator.next();

                    if(key == null || value == null) continue;

                    string = string.replace(key, value);
                }
            }
        }

        return parse(string);
    }

    public static List<String> parseAndReplace(List<String> list, String... replacements) {
        return list.stream()
                .map(line -> parseAndReplace(line, replacements))
                .filter(line -> !line.isEmpty())
                .collect(Collectors.toList());
    }
}