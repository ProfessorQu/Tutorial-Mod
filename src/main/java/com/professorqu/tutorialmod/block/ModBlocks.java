package com.professorqu.tutorialmod.block;

import com.professorqu.tutorialmod.TutorialMod;
import com.professorqu.tutorialmod.block.custom.FirestoneBlock;
import com.professorqu.tutorialmod.block.custom.OatsBlock;
import com.professorqu.tutorialmod.block.custom.trees.RedwoodTree;
import com.professorqu.tutorialmod.item.ModItemGroup;
import com.professorqu.tutorialmod.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.OakTree;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> AMETHYST_ORE = registerBlock("amethyst_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f)));

    public static final RegistryObject<Block> AMETHYST_BLOCK = registerBlock("amethyst_block",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(8f)));

    public static final RegistryObject<Block> FIRESTONE_BLOCK = registerBlock("firestone_block",
            () -> new FirestoneBlock(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(6f)));

    public static final RegistryObject<Block> AMETHYST_STAIRS = registerBlock("amethyst_stairs",
            () -> new StairsBlock(() -> AMETHYST_BLOCK.get().getDefaultState(),
                    AbstractBlock.Properties.create(Material.IRON)
                            .harvestLevel(3).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(6f)));

    public static final RegistryObject<Block> AMETHYST_FENCE = registerBlock("amethyst_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(6f)));

    public static final RegistryObject<Block> AMETHYST_FENCE_GATE = registerBlock("amethyst_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(6f)));

    public static final RegistryObject<Block> AMETHYST_SLAB = registerBlock("amethyst_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(6f)));

    public static final RegistryObject<Block> AMETHYST_BUTTON = registerBlock("amethyst_button",
            () -> new StoneButtonBlock(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(6f)
                    .doesNotBlockMovement()));

    public static final RegistryObject<Block> AMETHYST_PRESSURE_PLATE = registerBlock("amethyst_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    AbstractBlock.Properties.create(Material.IRON)
                            .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(6f)));

    public static final RegistryObject<Block> AMETHYST_DOOR = registerBlock("amethyst_door",
            () -> new DoorBlock(AbstractBlock.Properties.create(Material.IRON).harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(6f).notSolid()));

    public static final RegistryObject<Block> AMETHYST_TRAPDOOR = registerBlock("amethyst_trapdoor",
            () -> new TrapDoorBlock(AbstractBlock.Properties.create(Material.IRON).harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(6f).notSolid()));

    public static final RegistryObject<Block> OATS = BLOCKS.register("oats_crop",
            () -> new OatsBlock(AbstractBlock.Properties.from(Blocks.WHEAT)));

    public static final RegistryObject<Block> REDWOOD_LOG = registerBlock("redwood_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> REDWOOD_WOOD = registerBlock("redwood_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> STRIPPED_REDWOOD_LOG = registerBlock("stripped_redwood_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.STRIPPED_OAK_LOG)));

    public static final RegistryObject<Block> STRIPPED_REDWOOD_WOOD = registerBlock("stripped_redwood_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> REDWOOD_PLANKS = registerBlock("redwood_planks",
            () -> new Block(AbstractBlock.Properties.from(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> REDWOOD_LEAVES = registerBlock("redwood_leaves",
            () -> new LeavesBlock(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2f)
                    .tickRandomly().sound(SoundType.PLANT).notSolid()));

    public static final RegistryObject<Block> REDWOOD_SAPLING = registerBlock("redwood_sapling",
            () -> new SaplingBlock(new RedwoodTree(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
