package com.example.examplemod;

import ghcvm.runtime.*;
import hello.Export;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";
    public static Export HASKELL;

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // We need to init Haskell RTS once
        Rts.hsInit(new String[0], RtsConfig.getDefault());
        // Create our class with exported Haskell functions
        HASKELL = new Export();
    }

    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandHello());
    }
}
