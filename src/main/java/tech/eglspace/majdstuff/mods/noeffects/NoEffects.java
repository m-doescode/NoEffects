package tech.eglspace.majdstuff.mods.noeffects;

import net.minecraft.entity.EntityLiving;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

@Mod(
        modid = NoEffects.MOD_ID,
        name = NoEffects.MOD_NAME,
        version = NoEffects.VERSION
)
public class NoEffects {

    public static final String MOD_ID = "noeffects";
    public static final String MOD_NAME = "NoEffects";
    public static final String VERSION = "1.0-SNAPSHOT";

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @SuppressWarnings("unused")
    @Mod.Instance(MOD_ID)
    public static NoEffects INSTANCE;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {

    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }

    @Mod.EventBusSubscriber
    public static class EventHandler {
        @SubscribeEvent
        public static void onEffectGiven(PotionEvent.PotionApplicableEvent e) {
            // Remove effects
            e.getEntityLiving().clearActivePotions();
            e.setResult(Event.Result.DENY);
        }

        @SubscribeEvent
        public static void onEntityLoaded(EntityJoinWorldEvent e) {
            // Remove effects
            if (e.getEntity() instanceof EntityLiving)
                ((EntityLiving)e.getEntity()).clearActivePotions();
        }

        @SubscribeEvent
        public static void onPlayerLoaded(PlayerEvent.PlayerLoggedInEvent e) {
            // Remove effects
            e.player.clearActivePotions();
        }
    }
}
