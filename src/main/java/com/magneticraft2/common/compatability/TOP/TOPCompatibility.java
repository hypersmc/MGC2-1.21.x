package com.magneticraft2.common.compatability.TOP;

import com.magneticraft2.common.magneticraft2;
import mcjty.theoneprobe.api.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.fml.InterModComms;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.util.function.Function;

/**
 * @author JumpWatch on 25-06-2024
 * @Project MGC2-1.21.x
 * v1.0.0
 */
public class TOPCompatibility {
    public static final Logger LOGGER = LogManager.getLogger("MGC2-CompatibilityManager");
    private static boolean registered;
    private static final ResourceLocation resource = ResourceLocation.fromNamespaceAndPath(magneticraft2.MOD_ID, "default");
    public static void register(){
        if (registered) return;
        registered = true;
        InterModComms.sendTo("theoneprobe", "getTheOneProbe", GetTheOneProbe::new);
    }
    public static class GetTheOneProbe implements Function<ITheOneProbe, Void> {
        public static ITheOneProbe probe;
        @Nullable
        @Override
        public Void apply(ITheOneProbe tprobe) {
            probe = tprobe;
            LOGGER.info("Enabled support for The One Probe");
            probe.registerProvider(new IProbeInfoProvider() {
                @Override
                public ResourceLocation getID() {
                    return resource;
                }

                @Override
                public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, Player player, Level world, BlockState blockState, IProbeHitData data) {
                        if (blockState.getBlock() instanceof TOPDriver) {
                        TOPDriver provider = (TOPDriver) blockState.getBlock();
                        provider.addProbeInfo(mode, probeInfo, player, world, blockState, data);
                    }
                }
            });
            return null;
        }
    }
}
