package com.monkeyham.elendilmod.item.custom.shields;

import java.util.List;
import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.monkeyham.elendilmod.ElendilMod;

import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

public class GondorShield extends ShieldItem
{

    protected int maxDurability;

    public GondorShield(int defaultDurability,  Item.Properties prop)
    {
        // Increase durability by 25% with tower shields (will be reloaded when the server config is updated)
        super(prop);
        maxDurability = defaultDurability;
        if(FMLEnvironment.dist.isClient())
            ShieldBaseItem.registerShieldPropertyOverrides(this);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer)
    {
        consumer.accept(new IClientItemExtensions() {

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer()
            {
                return IClientItemExtensions.super.getCustomRenderer();
            }
        });
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair)
    {
        return false;
    }

    @Override
    public int getMaxDamage(ItemStack stack)
    {
        return maxDurability;
    }

    public void setMaxDamage(int maxDamage)
    {
        maxDurability = maxDamage;
    }

    @Override
    public String getDescriptionId(ItemStack stack)
    {
        // Prevents the display name from being overwritten by the shield base class (colour is now relegated to the tooltip)
        return getOrCreateDescriptionId();
    }

}