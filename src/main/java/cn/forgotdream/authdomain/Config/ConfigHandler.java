package cn.forgotdream.authdomain.Config;

import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ConfigHandler {
    private static final String CONFIG_PATH = "./plugins/Authdomain/config.yml";
    private static final String CONFIG_DIR = "./plugins/Authdomain";
    public List<?> allowedDomainList;
    private Configuration configuration;

    public ConfigHandler() {
        loadFile();
    }


    public void loadFile() {
        File settingsjson = new File(CONFIG_PATH);
        File settingsdir = new File(CONFIG_DIR);
        if (settingsjson.isFile() && settingsjson.exists()) {
            try {
                configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(settingsjson);
                this.allowedDomainList = configuration.getList("AllowedDomain");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                settingsdir.mkdirs();
                settingsjson.createNewFile();
                FileWriter fileWriter = new FileWriter(settingsjson);
                fileWriter.write("AllowedDomain:\n- 127.0.0.1\n- localhost");
                fileWriter.close();
                configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(settingsjson);
                this.allowedDomainList = configuration.getList("AllowedDomain");
                System.out.println("[Authdomain] Can't find config file...Create it...");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}