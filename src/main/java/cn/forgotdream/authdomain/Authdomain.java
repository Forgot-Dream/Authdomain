package cn.forgotdream.authdomain;

import cn.forgotdream.authdomain.Config.ConfigHandler;
import cn.forgotdream.authdomain.Listener.Handshake;
import net.md_5.bungee.api.plugin.Plugin;

public final class Authdomain extends Plugin {

    @Override
    public void onEnable() {
        System.out.println("[Authdomain] Loaded");
        getProxy().getPluginManager().registerListener(this, new Handshake());
        System.out.println("[Authdomain] Allowed Domain List :" + new ConfigHandler().allowedDomainList.toString());
        // Plugin startup logic
    }
}
