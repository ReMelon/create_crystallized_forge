package remelon.cat.crystallized;

import com.mojang.logging.LogUtils;
import com.simibubi.create.Create;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipHelper;
import com.simibubi.create.foundation.item.TooltipModifier;
import com.tterrag.registrate.Registrate;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import org.slf4j.Logger;

// Replace with your mod ID from mods.toml
@Mod(Crystallized.MODID)
public class Crystallized {
    public static final String MODID = "crystallized";
    public static final String NAME = "Create: Crystallized";
    public static final Logger LOGGER = LogUtils.getLogger();

    // CreateRegistrate instance for the mod
    public static final CreateRegistrate CREGISTRATE = CreateRegistrate.create(MODID);

    private static final CreateRegistrate CREGISTRATE = CreateRegistrate.create(ID)
            .defaultCreativeTab((ResourceKey<CreativeModeTab>) null)
            .setTooltipModifierFactory(item ->
                    new ItemDescription.Modifier(item, FontHelper.Palette.STANDARD_CREATE)
                            .andThen(TooltipModifier.mapNull(KineticStats.create(item)))
            );

    public Crystallized() {
        // Set tooltip modifier for all Create items



        // Register common setup
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);

        // Register to event bus
        FMLJavaModLoadingContext.get().getModEventBus().addListener(GroupRegister::registerItemGroups);

        // Register registries
        // ItemRegistrate.registerModItems();
        // FluidRegistrate.register();

        // Register everything in the registrate
        CREGISTRATE.register();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Create addon mod [{}] is loading alongside Create [{}]!", NAME, Create.VERSION);
    }
}
