package net.hynse.waterthing;

import net.hynse.waterthing.listeners.WaterSourceListener;

import me.nahu.scheduler.wrapper.FoliaWrappedJavaPlugin;
import me.nahu.scheduler.wrapper.WrappedScheduler;

public final class Waterthing extends FoliaWrappedJavaPlugin {

    public static Waterthing instance;

    public WrappedScheduler scheduler;

    @Override
    public void onEnable() {
        instance = this;
        scheduler = getScheduler();
        // Register the water source listener
        getServer().getPluginManager().registerEvents(new WaterSourceListener(), this);
    }
}
