package com.monkeyham.elendilmod;

import com.monkeyham.elendilmod.entity.ModEntities;
import com.monkeyham.elendilmod.entity.client.GeckoRenderer;
import com.monkeyham.elendilmod.entity.client.Gondor.GondorArcherRenderer;
import com.monkeyham.elendilmod.entity.client.Gondor.GondorInfantryRenderer;
import com.monkeyham.elendilmod.entity.client.Mordor.HumanoidModel.OrcHumanoidRenderer;
import com.monkeyham.elendilmod.entity.client.Mordor.OlogHaiRenderer;
import com.monkeyham.elendilmod.entity.client.Mordor.OrcArcherRenderer;
import com.monkeyham.elendilmod.entity.client.Mordor.OrcInfantryRenderer;
//import com.monkeyham.elendilmod.shields.model.GondorShieldModel;
//import com.monkeyham.elendilmod.shields.render.item.ModelLayers;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import org.jline.utils.Log;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = ElendilMod.MODID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = ElendilMod.MODID, value = Dist.CLIENT)
public class ElendilModClient {
    public ElendilModClient(ModContainer container) {
        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        ElendilMod.LOGGER.info("HELLO FROM CLIENT SETUP");
        ElendilMod.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

        EntityRenderers.register(ModEntities.GECKO.get(), GeckoRenderer::new);
        EntityRenderers.register(ModEntities.ORC_INFANTRY.get(), OrcInfantryRenderer::new);
        EntityRenderers.register(ModEntities.ORC_ARCHER.get(), OrcArcherRenderer::new);
        EntityRenderers.register(ModEntities.GONDOR_SOLDIER.get(), GondorInfantryRenderer::new);
        EntityRenderers.register(ModEntities.GONDOR_ARCHER.get(), GondorArcherRenderer::new);
        EntityRenderers.register(ModEntities.ORC_HUMANOID_INFANTRY.get(), OrcHumanoidRenderer::new);
        EntityRenderers.register(ModEntities.OLOG_HAI.get(), OlogHaiRenderer::new);
    }

    @SubscribeEvent
    public static void registerModelLayers(EntityRenderersEvent.RegisterLayerDefinitions ev){
        Log.info("Registering Model Layers!");
        //ev.registerLayerDefinition(ModelLayers.GONDOR_SHIELD, GondorShieldModel::createLayer);
        Log.info("Model Layer registration complete!");
    }

}
