package net.berrygames.bungee.listener;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerConnect implements Listener {

    @EventHandler
    public void onConnect(ServerConnectEvent event) {
        final var player = event.getPlayer();
        if(player.getServer() != null) return;

        // - Detect player client version and disconnect him if it's lower than 47 (v1.9).
        if(player.getPendingConnection().getVersion() <= 47) {
            event.setCancelled(true);
            player.disconnect(new TextComponent("player.disconnect.badVersion"));
            return;
        }

        // - Send player to Hub.
        //event.setTarget(null);
        //redis.sendPlayer(player.getName(), ServerType.HUB);

        // - Set tab header for player.
        player.setTabHeader(new TextComponent(""), new TextComponent(("")));
        // TODO: Until 30 seconds, disconnect player with no server message.
    }
}
