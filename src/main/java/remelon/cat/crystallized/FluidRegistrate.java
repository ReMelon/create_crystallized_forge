package remelon.cat.crystallized;

import com.tterrag.registrate.util.entry.FluidEntry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import static remelon.cat.crystallized.Crystallized.CREGISTRATE;
import static remelon.cat.crystallized.GroupRegistrate.CRYSTAL_GROUP_KEY;

public class FluidRegistrate {

    public static final ResourceLocation CRYSTAL_STILL_GEN = Crystallized.GenI("fluid/liquid_crystal_still");
    public static final ResourceLocation CRYSTAL_FLOW_GEN = Crystallized.GenI("fluid/liquid_crystal_flow");

    public static final FluidEntry<ForgeFlowingFluid.Flowing> CRYSTALFLUID = CREGISTRATE
            .fluid("liquid_crystal", CRYSTAL_STILL_GEN, CRYSTAL_FLOW_GEN)
            .lang("Liquid Crystal")
            .fluidProperties(p -> p
                    .levelDecreasePerBlock(2)
                    .tickRate(25)
                    .slopeFindDistance(4)
                    .explosionResistance(100f)
            )
            .source(ForgeFlowingFluid.Source::new)
            .block()
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_PINK))
            .lang("Liquid Crystal")
            .build()
            .bucket()
            .tab(CRYSTAL_GROUP_KEY)
            .lang("Liquid Crystal Bucket")
            .build()
            .register();


    public static void register() {    }
}
