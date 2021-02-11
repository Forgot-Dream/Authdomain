package cn.forgotdream.authdomain.mixin;

import net.minecraft.network.packet.c2s.handshake.HandshakeC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(HandshakeC2SPacket.class)
public interface MixinInterfaceHandshakeC2SPacket {
    @Accessor
    String getAddress();
}
