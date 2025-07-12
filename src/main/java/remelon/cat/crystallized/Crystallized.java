package remelon.cat.crystallized;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forgespi.locating.IModFile;
import net.minecraftforge.resource.PathPackResources;
import org.slf4j.Logger;

import java.nio.file.Path;

@Mod(Crystallized.MODID)
public class Crystallized {
    public static final String MODID = "crystallized";
    public static final String NAME = "Create: Crystallized";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final CreateRegistrate CREGISTRATE = CreateRegistrate.create(MODID);

    public Crystallized() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        GroupRegistrate.register(modEventBus);

        CREGISTRATE.registerEventListeners(modEventBus);

        ItemRegistrate.registerModItems();
        FluidRegistrate.register();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addPackFinders);
    }


    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    public static ResourceLocation GenI(String name) {
        return new ResourceLocation(MODID, name);
    }

    private void addPackFinders(final AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            IModFile modFile = ModList.get().getModFileById(MODID).getFile();

            event.addRepositorySource((packConsumer) -> {
                final Path resourcePath = modFile.findResource("rose_rename");

                final Pack pack = Pack.create(
                        MODID + ":rose_rename",
                        Component.translatable("pack.crystallized.rose_rename.displayName"),
                        false,
                        (packId) -> new PathPackResources(packId, true, resourcePath),
                        new Pack.Info(
                                Component.translatable("pack.crystallized.rose_rename.description"),
                                15,
                                FeatureFlags.VANILLA_SET
                        ),
                        PackType.CLIENT_RESOURCES,
                        Pack.Position.TOP,
                        false,
                        PackSource.BUILT_IN
                );
                packConsumer.accept(pack);
            });
        }
    }
}
