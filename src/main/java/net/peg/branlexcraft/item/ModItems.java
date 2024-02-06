package net.peg.branlexcraft.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.peg.branlexcraft.BranlexCraft;
import net.peg.branlexcraft.item.custom.MagicSwordItem;

public class ModItems {
    public static final Item BRANLEX_BALL = registerItem("branlex_ball", new Item(new FabricItemSettings()));
    public static final Item BRANLEX_SHEET = registerItem("branlex_sheet", new Item(new FabricItemSettings()));
    public static final Item BRANLEX_ROLL = registerItem("branlex_roll", new Item(new FabricItemSettings()));
    public static final Item BRANLEX_SWORD = registerItem("branlex_sword",
            new MagicSwordItem(ModToolMaterials.BRANLEX, 8, -2.4f, 8.0f, new FabricItemSettings(), new ItemStack(BRANLEX_BALL), new ItemStack(BRANLEX_BALL)));


    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(BRANLEX_SHEET);
        entries.add(BRANLEX_ROLL);
        entries.add(BRANLEX_SWORD);
        entries.add(BRANLEX_BALL);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BranlexCraft.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BranlexCraft.LOGGER.info("Redistering Mod Items for " + BranlexCraft.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
