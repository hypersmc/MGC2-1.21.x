package com.magneticraft2.common;

import com.magneticraft2.common.compatability.TOP.TOPCompatibility;
import com.magneticraft2.common.registry.FinalRegistry;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib.GeckoLib;

/**
 * @author JumpWatch on 25-06-2024
 * @Project MGC2-1.21.x
 * v1.0.0
 */
@Mod(magneticraft2.MOD_ID)
public class magneticraft2 {
    public static final Logger LOGGER = LogManager.getLogger("Magneticraft2");
    public static final String MOD_ID = "magneticraft2";

    public magneticraft2() {

        final IEventBus modEventBus = ModLoadingContext.get().getActiveContainer().getEventBus();
//        GeckoLib.initialize();
        FinalRegistry.register(modEventBus);
        modEventBus.addListener(this::preinit);
        modEventBus.addListener(this::registerCapabilities);
        modEventBus.addListener(this::preClient);
//        ModLoadingContext.get().getActiveContainer().getEventBus().addListener(ContainerAndScreenRegistry::Screen);
//        NeoForge.EVENT_BUS.register(this);
//        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> modEventBus.addListener(Clientsetup::init));
//        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Magneticraft2ConfigCommon.SPEC, "magneticraft2-common.toml");
//        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Magneticraft2ConfigClient.SPEC, "magneticraft2-client.toml");
//        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Magneticraft2ConfigServer.SPEC, "magneticraft2-server.toml");
    }



    public void preClient(final FMLClientSetupEvent event){
//        MultiblockManager.loadMultiblocks(MOD_ID, Minecraft.getInstance().getResourceManager());
//        BlueprintManager.loadBlueprints(MOD_ID, Minecraft.getInstance().getResourceManager());
    }
    public void preinit(final FMLCommonSetupEvent event){
        if (ModList.get().isLoaded("theoneprobe")){
            TOPCompatibility.register();
            LOGGER.info("The one probe compatibility done!");
        }
    }
    public void registerCapabilities(RegisterCapabilitiesEvent event){
//        CapabilityHeat.register(event);
//        CapabilityPressure.register(event);
//        CapabilityWatt.register(event);
    }
}
