package org.vmlurui.remclogin.listeners;

import org.vmlurui.remclogin.LoginMod;
import org.vmlurui.remclogin.PlayerLogin;
import net.minecraft.network.packet.s2c.play.TitleS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class OnPlayerConnect {
    public static void listen(ServerPlayerEntity player) {
        PlayerLogin playerLogin = LoginMod.getPlayer(player);
        //在如下区域填入进服提示
        //实测中发现优先级比MCDReforged的插件Joinmotd的高
        //会被顶掉
        playerLogin.setLoggedIn(false);
        player.setInvulnerable(true);
        player.sendMessage(Text.literal("§9你好! " +  player.getEntityName() + " !欢迎来到本服务器\n§e请使用 /reg 在本服务器注册。"), false);
        player.networkHandler.sendPacket(new TitleS2CPacket(Text.literal("§a欢迎!")));
    }
}
