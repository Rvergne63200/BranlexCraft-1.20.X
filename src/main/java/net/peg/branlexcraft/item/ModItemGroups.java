package net.peg.branlexcraft.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.peg.branlexcraft.BranlexCraft;

public class ModItemGroups {

    public static final ItemGroup BRANLEX_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(BranlexCraft.MOD_ID, "branlex"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.branlexcraft"))
                    .icon(() -> new ItemStack(ModItems.BRANLEX_ROLL)).entries((displayContext, entries) -> {
                        entries.add(ModItems.BRANLEX_SHEET);
                        entries.add(ModItems.BRANLEX_ROLL);
                        entries.add(ModItems.BRANLEX_SWORD);
                    }).build());

    public static void registerItemGroups(){
        BranlexCraft.LOGGER.info("Registering Item Groups for " + BranlexCraft.MOD_ID);
    }
}
