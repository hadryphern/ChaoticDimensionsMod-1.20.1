package net.blue.chaoticd.content.trade;

import java.util.List;
import java.util.Optional;
import net.blue.chaoticd.content.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

/**
 * The fixed, server-authoritative catalogue sold by Sir. Orens.
 *
 * <p>Vanilla villager offers accept at most two inputs and each input stack is
 * capped at 64.  Several Orens offers intentionally exceed both limits, so
 * they are represented here and completed by the custom trade menu instead of
 * being forced through {@code MerchantOffer}.</p>
 */
public record SirOrensTrade(
    int id,
    int level,
    List<Cost> costs,
    Item output,
    int outputCount
) {
    public static final List<SirOrensTrade> ALL = List.of(
        trade(0, 1, costs(
            cost(Items.LAVA_BUCKET, 1),
            cost(ModItems.EMERALD_INGOT, 50)
        ), ModItems.LAVA_INGOT, 1),
        trade(1, 2, costs(
            cost(Items.WATER_BUCKET, 1),
            cost(ModItems.RUBY, 50)
        ), ModItems.WATER_INGOT, 1),
        trade(2, 3, costs(
            cost(Items.IRON_INGOT, 350),
            cost(Items.DIAMOND, 250),
            cost(Items.EMERALD, 150),
            cost(ModItems.RUBY, 150),
            cost(ModItems.JAXY_GEM, 250),
            cost(ModItems.SHADOW_SOUL, 59)
        ), ModItems.VORTEX_GEM, 1),
        trade(3, 3, costs(
            cost(ModItems.SHADOW_SOUL, 350),
            cost(ModItems.VOID_SOUL, 350),
            cost(ModItems.VORTEX_SOUL, 250)
        ), ModItems.DEMONITH, 5),
        trade(4, 4, costs(
            cost(ModItems.AURORA_SOUL, 155),
            cost(ModItems.CRYSTALINE_SOUL, 155)
        ), ModItems.THE_CRYSTALINE, 1),
        trade(5, 4, costs(
            cost(ModItems.SHADOW_SOUL, 155),
            cost(ModItems.DEMONIC_SOULD, 155)
        ), ModItems.THE_UNDERGUER, 1),
        trade(6, 4, costs(
            cost(ModItems.SHADOW_SOUL, 155),
            cost(ModItems.AURORA_SOUL, 155)
        ), ModItems.THE_CALICE_QUEEN, 1),
        trade(7, 5, costs(
            cost(ModItems.MONTHRA_SCALE, 500),
            cost(ModItems.CRYSTALINE_SIGIL, 500),
            cost(ModItems.UNDERGUER_SIGIL, 500)
        ), ModItems.VOID, 1)
    );

    public SirOrensTrade {
        if (id < 0 || level < 1 || level > 5 || costs.isEmpty() || outputCount < 1) {
            throw new IllegalArgumentException("Invalid Sir. Orens trade definition");
        }
        costs = List.copyOf(costs);
    }

    public static Optional<SirOrensTrade> byId(int id) {
        return ALL.stream().filter(trade -> trade.id == id).findFirst();
    }

    public ItemStack outputStack() {
        return new ItemStack(output, outputCount);
    }

    private static SirOrensTrade trade(
        int id,
        int level,
        List<Cost> costs,
        Item output,
        int outputCount
    ) {
        return new SirOrensTrade(id, level, costs, output, outputCount);
    }

    private static List<Cost> costs(Cost... costs) {
        return List.of(costs);
    }

    private static Cost cost(Item item, int count) {
        return new Cost(item, count);
    }

    public record Cost(Item item, int count) {
        public Cost {
            if (count < 1) {
                throw new IllegalArgumentException("A Sir. Orens cost must be positive");
            }
        }

        public ItemStack displayStack() {
            return new ItemStack(item, Math.min(count, item.getMaxStackSize()));
        }
    }
}
