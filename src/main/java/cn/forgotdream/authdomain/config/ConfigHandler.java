package cn.forgotdream.authdomain.config;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ConfigHandler {
    private static final String CONFIG_PATH = "./config/Authdomain.json";
    public List<String> AllowedDomainList;

    public ConfigHandler() {
        loadFile();
    }

    public void loadFile() {
        File settingsjson = new File(CONFIG_PATH);
        if (settingsjson.isFile() && settingsjson.exists()) {
            try {
                JsonArray data = new JsonParser().parse(new FileReader(settingsjson)).getAsJsonObject().getAsJsonArray("AllowedDomain");
                Gson gson = new Gson();
                this.AllowedDomainList = gson.fromJson(data.toString(), new TypeToken<List<String>>() {
                }.getType());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileWriter fileWriter = new FileWriter(settingsjson);
                fileWriter.write("{\"AllowedDomain\":[\"127.0.0.1\",\n\"localhost\"\n]}");
                fileWriter.close();
                System.out.println("[AuthDomain] 配置文件不存在，已自动生成");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
