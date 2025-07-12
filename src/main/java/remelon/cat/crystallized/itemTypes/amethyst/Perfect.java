package remelon.cat.crystallized.itemTypes.amethyst;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

import javax.annotation.Nullable;
import java.util.List;

public class Perfect extends Item {

    public Perfect(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        tooltip.add(Component.translatable("item.crystallized.amethyst.tooltip").withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.translatable("item.crystallized.perfect.tooltip").withStyle(ChatFormatting.DARK_GRAY));
    }
}
