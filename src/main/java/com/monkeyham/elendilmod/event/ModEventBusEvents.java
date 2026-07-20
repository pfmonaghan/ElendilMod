package com.monkeyham.elendilmod.event;

import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.entity.ModEntities;
import com.monkeyham.elendilmod.entity.client.GeckoModel;
import com.monkeyham.elendilmod.entity.client.Gondor.GondorModel;
import com.monkeyham.elendilmod.entity.client.Mordor.HumanoidModel.OrcHumanoidModel;
import com.monkeyham.elendilmod.entity.client.Mordor.OrcArmorModel;
import com.monkeyham.elendilmod.entity.client.Mordor.OrcModel;
import com.monkeyham.elendilmod.entity.custom.GeckoEntity;
import com.monkeyham.elendilmod.entity.custom.Mordor.OlogHaiEntity;
import com.monkeyham.elendilmod.entity.custom.Mordor.OrcArcherEntity;
import com.monkeyham.elendilmod.entity.custom.Mordor.OrcInfantryEntity;
import com.monkeyham.elendilmod.entity.custom.Gondor.GondorArcherEntity;
import com.monkeyham.elendilmod.entity.custom.Gondor.GondorInfantryEntity;
import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
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
        event.registerLayerDefinition(OrcHumanoidModel.ORC_ARMOR_INNER_LAYER_LOCATION, ()-> LayerDefinition.create(HumanoidArmorModel.createBodyLayer(LayerDefinitions.INNER_ARMOR_DEFORMATION), 64, 32));
        event.registerLayerDefinition(OrcHumanoidModel.ORC_ARMOR_OUTER_LAYER_LOCATION, ()-> LayerDefinition.create(HumanoidArmorModel.createBodyLayer(LayerDefinitions.OUTER_ARMOR_DEFORMATION), 64, 32));
        event.registerLayerDefinition(OrcHumanoidModel.LAYER_LOCATION, ()->LayerDefinition.create(HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F), 64, 64));



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
        event.put(ModEntities.ORC_HUMANOID_INFANTRY.get(), GondorArcherEntity.createAttributes().build());
        event.put(ModEntities.OLOG_HAI.get(), OlogHaiEntity.createAttributes().build());
    }

}
