package cn.forgotdream.authdomain.mixin;

import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.c2s.handshake.HandshakeC2SPacket;
import net.minecraft.server.network.ServerHandshakeNetworkHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static cn.forgotdream.authdomain.util.CheckDomain.check;

@Mixin(ServerHandshakeNetworkHandler.class)
public abstract class MixinServerHandshakeNetworkHandler implements MixinInterfaceHandshakeC2SPacket {
    @Shadow
    @Final
    private ClientConnection connection;

    @Inject(method = "onHandshake", at = @At("HEAD"))
    private void CheckDomain(HandshakeC2SPacket packet, CallbackInfo cl) {
        String address = ((MixinInterfaceHandshakeC2SPacket) packet).getAddress();
        check(address, connection);
    }
}
