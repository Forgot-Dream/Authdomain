package cn.forgotdream.authdomain.util;

import net.minecraft.network.ClientConnection;
import net.minecraft.text.Text;

import static cn.forgotdream.authdomain.config.Configs.AllowedDomainList;

public class CheckDomain {
    public static void check(String address, ClientConnection connection) {
        if (!AllowedDomainList.contains(address)) {
            System.out.println("[Authdomain] Block Connection Use Domain >> " + address);
            connection.disconnect(Text.of("WARING : ILLEGAL CONNECTION."));
        }
    }
}
