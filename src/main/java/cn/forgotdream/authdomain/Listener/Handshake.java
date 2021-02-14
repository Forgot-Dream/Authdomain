package cn.forgotdream.authdomain.Listener;

import net.md_5.bungee.api.connection.PendingConnection;
import net.md_5.bungee.api.event.PlayerHandshakeEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import static cn.forgotdream.authdomain.util.CheckDomain.check;

public class Handshake implements Listener {

    @EventHandler
    public void onHandshake(PlayerHandshakeEvent event) {
        String address = event.getHandshake().getHost();
        PendingConnection connection = event.getConnection();
        check(address, connection);
    }

}
