package cn.forgotdream.authdomain;

import cn.forgotdream.authdomain.config.ConfigHandler;
import net.fabricmc.api.ModInitializer;

public class Authdomain implements ModInitializer {
    @Override
    public void onInitialize() {
        System.out.println("[Authdomain] Version : 1.0-SNAPSHOT");
        new ConfigHandler();
    }
}
