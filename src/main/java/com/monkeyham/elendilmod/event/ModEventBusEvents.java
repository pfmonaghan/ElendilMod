package com.monkeyham.elendilmod.event;

import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.entity.ModEntities;
import com.monkeyham.elendilmod.entity.client.GeckoModel;
import com.monkeyham.elendilmod.entity.client.Gondor.GondorModel;
import com.monkeyham.elendilmod.entity.client.Mordor.OrcArmorModel;
import com.monkeyham.elendilmod.entity.client.Mordor.OrcModel;
import com.monkeyham.elendilmod.entity.custom.GeckoEntity;
import com.monkeyham.elendilmod.entity.custom.OrcArcherEntity;
import com.monkeyham.elendilmod.entity.custom.OrcInfantryEntity;
import com.monkeyham.elendilmod.entity.custom.abstracts.GondorArcherEntity;
import com.monkeyham.elendilmod.entity.custom.abstracts.GondorInfantryEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = ElendilMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(GeckoModel.LAYER_LOCATION, GeckoModel::createBodyLayer);
        event.registerLayerDefinition(OrcModel.LAYER_LOCATION, OrcModel::createBodyLayer);
        event.registerLayerDefinition(GondorModel.LAYER_LOCATION, GondorModel::createBodyLayer);
        event.registerLayerDefinition(OrcArmorModel.ORC_ARMOR_INNER_LAYER_LOCATION, OrcArmorModel::createInnerArmorLayer);
        event.registerLayerDefinition(OrcArmorModel.ORC_ARMOR_OUTER_LAYER_LOCATION, OrcArmorModel::createOuterArmorLayer);



        //event.registerLayerDefinition(OrcArmorModel.ORC_ARMOR_OUTER_LAYER_LOCATION, OrcArmorModel::createOuterArmorLayer);
        //event.registerLayerDefinition(OrcArmorModel.ORC_ARMOR_INNER_LAYER_LOCATION, OrcArmorModel::createInnerArmorLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event)
    {
        event.put(ModEntities.GECKO.get(), GeckoEntity.createAttributes().build());
        event.put(ModEntities.ORC_INFANTRY.get(), OrcInfantryEntity.createAttributes().build());
        event.put(ModEntities.ORC_ARCHER.get(), OrcArcherEntity.createAttributes().build());
        event.put(ModEntities.GONDOR_SOLDIER.get(), GondorInfantryEntity.createAttributes().build());
        event.put(ModEntities.GONDOR_ARCHER.get(), GondorArcherEntity.createAttributes().build());
    }

}
