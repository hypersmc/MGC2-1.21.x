package com.magneticraft2.common.registry;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.magneticraft2.common.magneticraft2.MOD_ID;

/**
 * @author JumpWatch on 25-06-2024
 * @Project MGC2-1.21.x
 * v1.0.0
 */
//@EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class FinalRegistry {
    private static final Logger LOGGER = LogManager.getLogger("MGC2Registry");
    public static void register(IEventBus bus){
        LOGGER.info("Started to register Blocks, items etc.");
    }
}
