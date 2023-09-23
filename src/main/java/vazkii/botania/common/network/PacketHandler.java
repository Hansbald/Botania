package vazkii.botania.common.network;

import vazkii.botania.common.lib.LibMisc;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler {

    private PacketHandler() {}

    public static final SimpleNetworkWrapper INSTANCE =
            NetworkRegistry.INSTANCE.newSimpleChannel(LibMisc.MOD_ID.toLowerCase());

    public static void initPackets() {
        INSTANCE.registerMessage(PacketLokiToggle.class, PacketLokiToggle.class, 1, Side.SERVER);
        INSTANCE.registerMessage(PacketLokiToggleAck.class, PacketLokiToggleAck.class, 2, Side.CLIENT);
        INSTANCE.registerMessage(PacketLokiToggleBreaking.class, PacketLokiToggleBreaking.class, 3, Side.SERVER);
        INSTANCE.registerMessage(PacketLokiToggleBreakingAck.class, PacketLokiToggleBreakingAck.class, 4, Side.CLIENT);
        INSTANCE.registerMessage(PacketLokiClear.class, PacketLokiClear.class, 5, Side.SERVER);
        INSTANCE.registerMessage(PacketLokiClearAck.class, PacketLokiClearAck.class, 6, Side.CLIENT);
    }
}