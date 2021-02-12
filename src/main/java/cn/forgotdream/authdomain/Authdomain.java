package cn.forgotdream.authdomain;

import cn.forgotdream.authdomain.config.ConfigHandler;
import net.fabricmc.api.ModInitializer;

import static cn.forgotdream.authdomain.util.Print.print_message;

public class Authdomain implements ModInitializer {
    @Override
    public void onInitialize() {
        print_message("Version : 1.0-SNAPSHOT");
        new ConfigHandler();//Check Config
    }
}
