package cn.forgotdream.authdomain.util;

import cn.forgotdream.authdomain.Config.ConfigHandler;
import net.md_5.bungee.api.connection.PendingConnection;

import java.util.List;

public class CheckDomain {
    private static final List<String> AllowedDomainList = (List<String>) new ConfigHandler().allowedDomainList;

    public static void check(String address, PendingConnection connection) {
        if (!AllowedDomainList.contains(address)) {
            System.out.println("[AuthDomain] Block Domain >> " + address);
            connection.disconnect("Unknown Host");
        }
    }
}