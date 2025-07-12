package remelon.cat.crystallized;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Crystallized.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GroupRegistrate {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Crystallized.MODID);

    public static final ResourceKey<CreativeModeTab> CRYSTAL_GROUP_KEY =
            ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(Crystallized.MODID, "itemtab"));

    public static final RegistryObject<CreativeModeTab> CRYSTAL_GROUP = CREATIVE_MODE_TABS.register("itemtab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("crystallized.itemtab"))
                    .icon(() -> new ItemStack(ItemRegistrate.NETHER_CRYSTAL.get()))
                    .displayItems((params, output) -> {
                    })
                    .build());

    public static void register(IEventBus modEventBus) {
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
