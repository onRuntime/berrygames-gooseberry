package net.berrygames.bungee.task;

import net.md_5.bungee.api.Callback;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.ServerPing;

/**
 * This file is a part of BerryGames, located on net.berrygames.bungee.task
 *
 * @author SweetKebab_
 * Created the 10/12/19 at 9:02 PM.
 */
public class PingTask implements Runnable {
    @Override
    public void run() {
        ProxyServer.getInstance().getServers().forEach((ip, sese) -> sese.ping((result, error) -> {
            if(result.getDescriptionComponent() == null)
                ProxyServer.getInstance().getServers().remove(sese.getName());
        }));
    }
}
