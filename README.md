# What is qCore?

#####  If you are tired of plugins like EssentialsX with 130 unnecessary commands, this plugin is for you. If you want to add features, just create support in the profile section.

If there is a feature you want me to add, contact me via discord *(Discord link at the bottom)*



### Features

**SPAWN**
- Respawn, start at spawn. *(true/false)*
- Teleport to the spawn when you fall into the void. *(true/false)*
- First Join start at spawn. *(true/false)*
- Join start at spawn. *(true/false)*
- Sends a message to the player when the "/spawn" command is used!
- Sends a message to the player if "/spawn" is not set.

**INTERACTIVE BLOCKS**
- Preventing the opening of furnuce, worckbench etc. blocks added to the list in config.yml. *(true/false)*
- Sending message when clicking on blocks added to the list in config.yml *(true/false)*

**TIME LOOP/AUTO COMMAND**
- Sending commands to the server at the time and minute you specify and sending messages to players with permission. *(true/false)*


##### EXAMPLE 
<3 @Despical
``` 
 '1':
    hour: 12
    minutes: 00
    commands:
      - "/kick erisos"
    message: "Erisos kick."
    # Sends messages only to players with permission. Leave blank if you don''t want this.
    message_perm: test.message
```

**SWEAR BLOCKLER (BETA)**
- It checks the messages sent by the players and if it detects a forbidden word in the list, it blocks the message and sends a large warning message to the screen.

**JOIN TITLE**
- Sending title to the screen when the player enters the game. *(true/false)*

**ALLOWED COMMAND**
- If the player uses a command that is not in the list, an error message is sent to the player.
- If the setting is true, when the player sends a command that is not in the list, it sends title to the screen and warns the player. *(true/false)*

**DISCORD**
- If the player uses the "**/discord**" command, it sends the discord link set in config.yml to the player.

**JOIN/LEAVE MESSAGES**
- Deactivates players join and quit messages. *(true/false)*



### Commands & Permissions
- /qSetSpawn = qcore.setspawn
- /spawn = qcore.spawn
- /qDefaultPlayerEffect = qcore.admin
- /discord = Not Perm
- Chat Use = qcore.chat
- Allowed Commands Bypass = qcore.command


[![Discord](https://cdn.discordapp.com/attachments/1192048090832711680/1203384882999328809/discord.png?ex=65d0e681&is=65be7181&hm=0d3a7f062000edd25b58e3524f009df8c47f8180be25dc5bc4452c59ba68dc8c& "Discord")](https://discord.gg/EsFhKcDMbh "Discord")








