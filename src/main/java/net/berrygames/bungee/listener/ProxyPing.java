package net.berrygames.bungee.listener;

import net.berrygames.bungee.utilities.CenteredMessage;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ProxyPing implements Listener {

    @EventHandler
    public void onPing(ProxyPingEvent event){
        ServerPing serverPing;
        int maxSlot = 500;
        int online = getOnlinePlayers();
        // String line1 = "&2&l▪&a&l▪&e&l▪ &a&lBerryGames &7Game Server &2[1.9 »&2 1.13] &e&l▪&a&l▪&2&l▪";
        //String line1 = "&5&lBerry&d&lGames &f❙ &b&lMINI GAMES &f❙ &91.9 ➟ 1.12.2";
        //String line2 = "&a☆ &6The server is currently under development &a☆    ";
        //String line2 = "&b☆ &aThe server is currently in development &b☆    ";
        String line1 = "§6§lBerryGames &f❙ §a1.9 §8➟ §a1.12.2";
        String line2 = "§b§lTwitter §f» §9@BerryGamesMC";

        if (event.getConnection().getVersion() <= 47) {
            serverPing = new ServerPing(
                    new ServerPing.Protocol("§4Use 1.9 ➟ 1.12.2 §f- §7" + online + "§8/§7" + maxSlot, 48),
                    new ServerPing.Players(maxSlot, online, null),
                    CenteredMessage.getCenteredMotd(line1) + "\n" + CenteredMessage.getCenteredMotd("§cUse 1.9 ➟ 1.12.2"),
                    ProxyServer.getInstance().getConfig().getFaviconObject());
        } else {
            serverPing = new ServerPing(
                    new ServerPing.Protocol("§7" + online + "§8/§7" + maxSlot, event.getConnection().getVersion()),
                    new ServerPing.Players(maxSlot, online, null),
                    CenteredMessage.getCenteredMotd(line1) + "\n" + CenteredMessage.getCenteredMotd(line2),
                    ProxyServer.getInstance().getConfig().getFaviconObject()
                    );
        }
        event.setResponse(serverPing);
    }

    private int getOnlinePlayers(){
        return 0;
    }
}