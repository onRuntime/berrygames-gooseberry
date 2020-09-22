package net.berrygames.bungee;

import net.berrygames.bungee.listener.PlayerConnect;
import net.berrygames.bungee.listener.ProxyPing;
import net.berrygames.cloudberry.proxy.BerryProxy;
import net.berrygames.translation.ITranslatable;
import net.berrygames.translation.Translatable;
import net.md_5.bungee.api.ProxyServer;

public class GooseBerry extends BerryProxy {

    // - General Managers
    private RedisService redisService;
    private ITranslatable translatable;

    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    public void onEnable() {
        super.onEnable();

        // - Initialize General managers
        this.redisService = new RedisServiceImpl("127.0.0.1", 6379, "Sunntitane2", 0);
        this.translatable = new Translatable();

        // - Register listeners
        ProxyServer.getInstance().getPluginManager().registerListener(this, new PlayerConnect());
        ProxyServer.getInstance().getPluginManager().registerListener(this, new ProxyPing());
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public RedisService getRedis() {
        return redisService;
    }

    @Override
    public ITranslatable getTranslatable() {
        return translatable;
    }
}
