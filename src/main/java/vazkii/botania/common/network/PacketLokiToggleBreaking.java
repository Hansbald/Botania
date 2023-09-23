package vazkii.botania.common.network;

import io.netty.buffer.ByteBuf;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import vazkii.botania.common.item.relic.ItemLokiRing;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketLokiToggleBreaking implements IMessage, IMessageHandler<PacketLokiToggleBreaking, IMessage> {
    @Override
    public void fromBytes(ByteBuf byteBuf) {
        // not needed
    }

    @Override
    public void toBytes(ByteBuf byteBuf) {
        // not needed
    }

    @Override
    public IMessage onMessage(PacketLokiToggleBreaking message, MessageContext ctx) {
        EntityPlayerMP player = ctx.getServerHandler().playerEntity;
        final ItemStack aRing = ItemLokiRing.getLokiRing(player);
        if (aRing != null) {
            boolean ringState = !ItemLokiRing.isRingBreakingEnabled(aRing);
            ItemLokiRing.setBreakingMode(aRing, ringState);
            PacketLokiToggleBreakingAck ackMessage = new PacketLokiToggleBreakingAck();
            ackMessage.state = ringState;
            PacketHandler.INSTANCE.sendTo(ackMessage, player);
        }
        return null;
    }
}