package net.peg.branlexcraft.advancement;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.peg.branlexcraft.BranlexCraft;
import net.peg.branlexcraft.item.ModItems;

import java.util.function.Consumer;

public class AdvancementsProvider extends FabricAdvancementProvider {
    public AdvancementsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<AdvancementEntry> consumer) {
        AdvancementEntry branlexSwordAdvancement = Advancement.Builder.create()
                .display(
                        ModItems.BRANLEX_SWORD,
                        Text.translatable("branlex_sword_advancement_title"),
                        Text.translatable("branlex_sword_advancement_desc"),
                        new Identifier("textures/gui/advancements/background/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_branlex_sword", InventoryChangedCriterion.Conditions.items(ModItems.BRANLEX_SWORD))
                .build(consumer, BranlexCraft.MOD_ID + "/branlex_sword");

        AdvancementEntry goldenBranlexAdvancement = Advancement.Builder.create()
                .display(
                        ModItems.GOLDEN_BRANLEX_SHEET,
                        Text.translatable("golden_branlex_advancement_title"),
                        Text.translatable("golden_branlex_advancement_desc"),
                        new Identifier("textures/gui/advancements/background/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_golden_branlex_sheet", InventoryChangedCriterion.Conditions.items(ModItems.GOLDEN_BRANLEX_SHEET))
                .build(consumer, BranlexCraft.MOD_ID + "/golden_branlex_sheet");

        AdvancementEntry goldenBranlexSwordAdvancement = Advancement.Builder.create()
                .display(
                        ModItems.GOLDEN_BRANLEX_SWORD,
                        Text.translatable("golden_branlex_sword_advancement_title"),
                        Text.translatable("golden_branlex_sword_advancement_desc"),
                        new Identifier("textures/gui/advancements/background/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_golden_branlex_sword", InventoryChangedCriterion.Conditions.items(ModItems.GOLDEN_BRANLEX_SWORD))
                .build(consumer, BranlexCraft.MOD_ID + "/golden_branlex_sword");
    }
}
