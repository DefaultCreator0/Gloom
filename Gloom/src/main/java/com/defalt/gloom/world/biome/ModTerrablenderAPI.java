package com.defalt.gloom.world.biome;

import com.defalt.gloom.Gloom;
import com.defalt.gloom.world.biome.surface.ModMaterialRules;
import net.minecraft.util.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {

    @Override
    public void onTerraBlenderInitialized() {

        Regions.register(new ModOverworldRegion(new Identifier(Gloom.ModID, "overworld"),4));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, Gloom.ModID, ModMaterialRules.makeRules());
    }


}
