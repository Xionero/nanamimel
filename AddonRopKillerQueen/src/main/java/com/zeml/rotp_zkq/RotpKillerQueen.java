package com.zeml.rotp_zkq;

import com.zeml.rotp_zkq.init.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(RotpKillerQueen.MOD_ID)
public class RotpKillerQueen {
    // The value here should match an entry in the META-INF/mods.toml file
    public static final String MOD_ID = "rotp_zkq";
    private static final Logger LOGGER = LogManager.getLogger();

    public RotpKillerQueen() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        InitEntities.ENTITIES.register(modEventBus);
        InitSounds.SOUNDS.register(modEventBus);
        InitStands.ACTIONS.register(modEventBus);
        InitStands.STANDS.register(modEventBus);

        ModEntityTypes.ENTITIES.register(modEventBus);
    }



    public static Logger getLogger() {
        return LOGGER;
    }
}
