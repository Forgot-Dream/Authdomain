package cn.forgotdream.authdomain.util;

import net.minecraft.network.ClientConnection;
import net.minecraft.text.Text;

import static cn.forgotdream.authdomain.config.Configs.AllowedDomainList;
import static cn.forgotdream.authdomain.util.Print.print_message;

public class CheckDomain {
    public static void check(String address, ClientConnection connection) {
        if (!AllowedDomainList.contains(address)) {
            print_message("Block Domain >> " + address);
            connection.disconnect(Text.of("WARING : ILLEGAL CONNECTION."));
        }
    }
}
