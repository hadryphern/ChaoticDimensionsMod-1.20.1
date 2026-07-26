package net.blue.chaoticd.validation;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import javax.imageio.ImageIO;

/**
 * Packaging validator for Aurora, Shadow, Dream Fluid and Emerald assets.
 *
 * <p>Required assets are checked, while future extra textures are allowed.</p>
 */
public final class AuroraAssetsValidator {
    private static final Path ROOT =
        Path.of("build/resources/main");

    private static final Path ASSETS =
        ROOT.resolve("assets/chaoticd");

    private static final Path DATA =
        ROOT.resolve("data/chaoticd");

    private static final Set<String> REQUIRED_BLOCKS = Set.of(
        "aurora_dirt",
        "aurora_grass_block",
        "aurora_stone",
        "aurora_pinkko_log",
        "stripped_aurora_pinkko_log",
        "aurora_pinkko_planks",
        "aurora_pinkko_leaves",
        "aurora_pinkko_sapling",
        "aurora_souless_log",
        "stripped_aurora_souless_log",
        "aurora_souless_planks",
        "aurora_souless_leaves",
        "aurora_souless_sapling",
        "aurora_sky_log",
        "stripped_aurora_sky_log",
        "aurora_sky_planks",
        "aurora_sky_leaves",
        "aurora_sky_sapling",
        "ruby_ore",
        "jax_ore",
        "rosalita_ore",
        "nether_ruby_ore",
        "nether_jax_ore",
        "nether_rosalita_ore",
        "aurora_ruby_ore",
        "aurora_jax_ore",
        "aurora_rosalita_ore",
        "aurora_sapphire_ore",
        "shadow_soil",
        "shadow_grass",
        "shadow_stone",
        "shadow_log",
        "shadow_wood",
        "stripped_shadow_log",
        "stripped_shadow_wood",
        "shadow_planks",
        "shadow_leaves"
    );

    private static final Set<String> REQUIRED_BLOCK_TEXTURES = Set.of(
        "aurora_dirt",
        "aurora_grass_block",
        "aurora_grass_block_top",
        "aurora_stone",
        "aurora_pinkko_log",
        "aurora_pinkko_log_top",
        "stripped_aurora_pinkko_log",
        "stripped_aurora_pinkko_log_top",
        "aurora_pinkko_planks",
        "aurora_pinkko_sappling",
        "aurora_souless_log",
        "aurora_souless_log_top",
        "stripped_aurora_souless_log",
        "stripped_aurora_souless_log_top",
        "aurora_souless_planks",
        "aurora_souless_sappling",
        "aurora_sky_log",
        "aurora_sky_log_top",
        "stripped_aurora_sky_log",
        "stripped_aurora_sky_log_top",
        "aurora_sky_planks",
        "aurora_sky_sappling",
        "aurora_leaves_1",
        "aurora_leaves_2",
        "aurora_leaves_3",
        "ruby_ore",
        "jaxy_ore",
        "rosalita_ore",
        "nether_ruby_ore",
        "nether_jax_ore",
        "nether_rosalita",
        "aurora_ruby_ore",
        "aurora_jaxy_ore",
        "aurora_rosalita_ore",
        "aurora_sapphire_ore",
        "shadow_soil",
        "shadow_grass",
        "shadow_grass_side",
        "shadow_stone",
        "shadow_log",
        "shadow_log_top",
        "stripped_shadow_log",
        "stripped_shadow_log_top",
        "shadow_planks",
        "shadow_leaves"
    );

    private static final Set<String> LEAF_TEXTURES = Set.of(
        "aurora_leaves_1",
        "aurora_leaves_2",
        "aurora_leaves_3",
        "shadow_leaves"
    );

    private static final Set<String> SAPLING_TEXTURES = Set.of(
        "aurora_pinkko_sappling",
        "aurora_souless_sappling",
        "aurora_sky_sappling"
    );

    private static final List<String> EMERALD_ITEMS = List.of(
        "emerald_ingot",
        "emerald_sword",
        "emerald_pickaxe",
        "emerald_axe",
        "emerald_shovel",
        "emerald_hoe",
        "emerald_helmet",
        "emerald_chestplate",
        "emerald_leggings",
        "emerald_boots",
        "titanium_helmet",
        "titanium_chestplate",
        "titanium_leggings",
        "titanium_boots",
        "aurora_pearl",
        "dream_fluid_bucket",
        "crystaline_see"
    );

    private AuroraAssetsValidator() {
    }

    public static void main(String[] args)
        throws IOException {

        requireFile(ROOT.resolve("pack.mcmeta"));
        validateEveryJson();
        validateBlockCoverage();
        validateBlockTextures();
        validateModelReferences();
        validateEmeraldAndDreamAssets();
        validateRequiredTags();

        System.out.println(
            "AURORA/SHADOW/DREAM ASSET VALIDATION PASSED: "
                + REQUIRED_BLOCKS.size()
                + " required blocks, "
                + REQUIRED_BLOCK_TEXTURES.size()
                + " required block textures and "
                + EMERALD_ITEMS.size()
                + " Emerald/Dream item assets."
        );
    }

    private static void validateEveryJson()
        throws IOException {

        try (Stream<Path> files = Files.walk(ROOT)) {
            for (
                Path file : files
                    .filter(Files::isRegularFile)
                    .filter(path ->
                        path.toString().endsWith(".json")
                            || path.getFileName()
                                .toString()
                                .equals("pack.mcmeta")
                    )
                    .toList()
            ) {
                readJson(file);
            }
        }
    }

    private static void validateBlockCoverage() {
        for (String id : REQUIRED_BLOCKS) {
            requireFile(
                ASSETS.resolve(
                    "blockstates/" + id + ".json"
                )
            );

            requireFile(
                ASSETS.resolve(
                    "models/item/" + id + ".json"
                )
            );

            requireFile(
                DATA.resolve(
                    "loot_tables/blocks/" + id + ".json"
                )
            );
        }
    }

    private static void validateBlockTextures()
        throws IOException {

        Path textureRoot =
            ASSETS.resolve("textures/block");

        Set<String> actual =
            new LinkedHashSet<>();

        try (Stream<Path> files = Files.list(textureRoot)) {
            files
                .filter(path ->
                    path.toString().endsWith(".png")
                )
                .map(path ->
                    path.getFileName()
                        .toString()
                        .replaceFirst("\\.png$", "")
                )
                .sorted()
                .forEach(actual::add);
        }

        Set<String> missing =
            new LinkedHashSet<>(
                REQUIRED_BLOCK_TEXTURES
            );

        missing.removeAll(actual);

        check(
            missing.isEmpty(),
            "Missing required block textures: "
                + missing
        );

        for (String id : REQUIRED_BLOCK_TEXTURES) {
            Path file =
                textureRoot.resolve(id + ".png");

            BufferedImage image =
                ImageIO.read(file.toFile());

            check(
                image != null,
                "Unreadable PNG: " + file
            );

            check(
                image.getWidth() == image.getHeight()
                    && (image.getWidth() == 16 || image.getWidth() == 128),
                "Block texture must be square 16x16 or 128x128: "
                    + file
            );

            int transparent = 0;

            for (int y = 0; y < image.getHeight(); y++) {
                for (
                    int x = 0;
                    x < image.getWidth();
                    x++
                ) {
                    if ((image.getRGB(x, y) >>> 24) == 0) {
                        transparent++;
                    }
                }
            }

            if (LEAF_TEXTURES.contains(id)) {
                double ratio =
                    transparent
                        / (double)(
                            image.getWidth()
                                * image.getHeight()
                        );

                check(
                    ratio >= 0.10D
                        && ratio <= 0.65D,
                    "Leaf alpha ratio outside 10%-65%: "
                        + id
                        + "="
                        + ratio
                );
            } else if (SAPLING_TEXTURES.contains(id)) {
                check(
                    transparent > 0,
                    "Sapling texture must contain transparent pixels: " + id
                );
            } else {
                check(
                    transparent == 0,
                    "Opaque block texture contains "
                        + "transparent pixels: "
                        + id
                );
            }
        }
    }

    private static void validateModelReferences()
        throws IOException {

        Path blockstates =
            ASSETS.resolve("blockstates");

        try (Stream<Path> files = Files.list(blockstates)) {
            for (
                Path file : files
                    .filter(path ->
                        path.toString().endsWith(".json")
                    )
                    .toList()
            ) {
                Set<String> models =
                    new LinkedHashSet<>();

                collectNamedStrings(
                    readJson(file),
                    "model",
                    models
                );

                for (String model : models) {
                    requireModModel(model, file);
                }
            }
        }

        Path models =
            ASSETS.resolve("models");

        try (Stream<Path> files = Files.walk(models)) {
            for (
                Path file : files
                    .filter(path ->
                        path.toString().endsWith(".json")
                    )
                    .toList()
            ) {
                JsonObject model =
                    readJson(file).getAsJsonObject();

                if (model.has("parent")) {
                    requireModModel(
                        model.get("parent").getAsString(),
                        file
                    );
                }

                if (!model.has("textures")) {
                    continue;
                }

                for (
                    var entry :
                        model.getAsJsonObject("textures")
                            .entrySet()
                ) {
                    String texture =
                        entry.getValue().getAsString();

                    if (
                        texture.startsWith("#")
                            || !texture.startsWith(
                                "chaoticd:"
                            )
                    ) {
                        continue;
                    }

                    String local =
                        texture.substring(
                            "chaoticd:".length()
                        );

                    requireFile(
                        ASSETS.resolve(
                            "textures/"
                                + local
                                + ".png"
                        ),
                        "Missing texture "
                            + texture
                            + " referenced by "
                            + file
                    );
                }
            }
        }
    }

    private static void validateEmeraldAndDreamAssets()
        throws IOException {

        for (String id : EMERALD_ITEMS) {
            requireFile(
                ASSETS.resolve(
                    "models/item/" + id + ".json"
                )
            );

            Path texture =
                ASSETS.resolve(
                    "textures/item/" + id + ".png"
                );

            requireFile(texture);

            BufferedImage image =
                ImageIO.read(texture.toFile());

            check(
                image != null,
                "Unreadable item texture: "
                    + texture
            );

            check(
                image.getWidth() == 16
                    && image.getHeight() == 16,
                "Item texture is not 16x16: "
                    + texture
            );
        }

        requireFile(
            ASSETS.resolve(
                "textures/item/death_totem.png"
            )
        );

        validateArmorLayer("emerald_layer_1.png");
        validateArmorLayer("emerald_layer_2.png");
        validateArmorLayer("ruby_layer_1.png");
        validateArmorLayer("ruby_layer_2.png");
        validateArmorLayer("titanium_layer_1.png");
        validateArmorLayer("titanium_layer_2.png");

        requireFile(
            DATA.resolve(
                "structures/dream_fluid_island.nbt"
            )
        );

        requireFile(
            DATA.resolve(
                "worldgen/structure/"
                    + "dream_fluid_island.json"
            )
        );

        requireFile(
            DATA.resolve(
                "worldgen/structure_set/"
                    + "dream_fluid_islands.json"
            )
        );

        requireFile(
            DATA.resolve(
                "structures/dream_fluid_cavern.nbt"
            )
        );

        requireFile(
            DATA.resolve(
                "worldgen/structure/"
                    + "dream_fluid_cavern.json"
            )
        );

        requireFile(
            DATA.resolve(
                "worldgen/structure/"
                    + "dream_fluid_sky_lake.json"
            )
        );

        requireFile(
            DATA.resolve(
                "worldgen/structure_set/"
                    + "dream_fluid_overworld_lakes.json"
            )
        );

        requireFile(
            DATA.resolve(
                "tags/worldgen/structure/"
                    + "dream_fluid_aurora.json"
            )
        );

        requireFile(
            DATA.resolve(
                "tags/worldgen/structure/"
                    + "dream_fluid_overworld.json"
            )
        );
    }

    private static void validateArmorLayer(
        String fileName
    ) throws IOException {

        Path file =
            ASSETS.resolve(
                "textures/models/armor/" + fileName
            );

        requireFile(file);

        BufferedImage image =
            ImageIO.read(file.toFile());

        check(
            image != null,
            "Unreadable armor texture: " + file
        );

        check(
            image.getWidth() == 64
                && image.getHeight() == 32,
            "Armor layer is not 64x32: " + file
        );
    }

    private static void validateRequiredTags() {
        requireFile(
            DATA.resolve(
                "tags/fluids/dream_fluid.json"
            )
        );

        requireFile(
            ROOT.resolve(
                "data/minecraft/tags/fluids/water.json"
            )
        );

        requireFile(
            DATA.resolve(
                "tags/blocks/aurora_logs.json"
            )
        );

        requireFile(
            DATA.resolve(
                "tags/blocks/shadow_logs.json"
            )
        );
    }

    private static JsonElement readJson(Path file)
        throws IOException {

        try (
            Reader reader =
                Files.newBufferedReader(file)
        ) {
            JsonElement json =
                JsonParser.parseReader(reader);

            check(
                json != null
                    && !json.isJsonNull(),
                "Empty JSON: " + file
            );

            return json;
        } catch (RuntimeException exception) {
            throw new IllegalStateException(
                "Invalid JSON: " + file,
                exception
            );
        }
    }

    private static void collectNamedStrings(
        JsonElement element,
        String field,
        Set<String> values
    ) {
        if (element.isJsonArray()) {
            element.getAsJsonArray().forEach(
                child ->
                    collectNamedStrings(
                        child,
                        field,
                        values
                    )
            );

            return;
        }

        if (!element.isJsonObject()) {
            return;
        }

        for (
            var entry :
                element.getAsJsonObject().entrySet()
        ) {
            if (
                entry.getKey().equals(field)
                    && entry.getValue()
                        .isJsonPrimitive()
            ) {
                values.add(
                    entry.getValue().getAsString()
                );
            } else {
                collectNamedStrings(
                    entry.getValue(),
                    field,
                    values
                );
            }
        }
    }

    private static void requireModModel(
        String id,
        Path source
    ) {
        if (!id.startsWith("chaoticd:")) {
            return;
        }

        String local =
            id.substring("chaoticd:".length());

        requireFile(
            ASSETS.resolve(
                "models/" + local + ".json"
            ),
            "Missing model "
                + id
                + " referenced by "
                + source
        );
    }

    private static void requireFile(Path file) {
        requireFile(
            file,
            "Missing required file: " + file
        );
    }

    private static void requireFile(
        Path file,
        String message
    ) {
        check(
            Files.isRegularFile(file),
            message
        );
    }

    private static void check(
        boolean condition,
        String message
    ) {
        if (!condition) {
            throw new IllegalStateException(message);
        }
    }
}
