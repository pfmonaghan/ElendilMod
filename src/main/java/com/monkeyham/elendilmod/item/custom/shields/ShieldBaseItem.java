package com.monkeyham.elendilmod.item.custom.shields;

import java.util.function.Consumer;


import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

public class ShieldBaseItem extends ShieldItem
{

	public static void registerShieldPropertyOverrides(ShieldItem item)
	{
		ItemProperties.register(item, ResourceLocation.withDefaultNamespace("blocking"), (stack, world, living, value) ->
		{
			return living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0f : 0.0f;
		});
	}
	
    protected int maxDurability;

	public ShieldBaseItem(int defaultDurability, Item.Properties prop)
	{
		// Increase durability by 25% with tower shields (will be reloaded when the server config is updated)
		super(prop.durability(defaultDurability));
		maxDurability = defaultDurability;
	}
	
	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer)
	{
		consumer.accept(new IClientItemExtensions() {
			
			@Override
			public BlockEntityWithoutLevelRenderer getCustomRenderer() 
			{
				return IClientItemExtensions.super.getCustomRenderer() ;
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
        maxDurability =  maxDamage;
    }
    
//    @Override
//    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag)
//    {
//    	addEffectsTooltip(stack, context.level(), tooltipComponents, tooltipFlag);
//    }
	
	@Override
	public String getDescriptionId(ItemStack stack) 
	{
		// Prevents the display name from being overwritten by the shield base class (colour is now relegated to the tooltip) 
		return getOrCreateDescriptionId();
	}
    
//    @OnlyIn(Dist.CLIENT)
//    public void addEffectsTooltip(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flagIn)
//    {
//    	if(stack.getEnchantmentLevel(ModEnchantments.PAYBACK.get()) != 0)
//    	{
//    		float paybackDamage = stack.getOrCreateTag().getFloat(PaybackEnchantment.NBT_PAYBACK_DMG);
//    		tooltip.add(Component.translatable("tooltip." + ModSpartanShields.ID + ".payback_bonus", ChatFormatting.GRAY.toString() + Float.toString(paybackDamage)).withStyle(ChatFormatting.LIGHT_PURPLE));
//    	}
//    }
}