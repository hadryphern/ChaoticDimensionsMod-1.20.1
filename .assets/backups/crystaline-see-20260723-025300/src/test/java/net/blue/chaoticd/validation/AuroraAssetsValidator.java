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
        "pastel_soil",
        "pastel_grass",
        "pastel_aurora_stone",
        "pastel_aurora_log",
        "pastel_aurora_wood",
        "stripped_pastel_aurora_log",
        "stripped_pastel_aurora_wood",
        "pastel_aurora_planks",
        "pastel_pink_leaves",
        "pastel_purple_leaves",
        "pastel_blue_leaves",
        "sapphire_ore",
        "rosalita_ore",
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
        "pastel_soil",
        "pastel_grass",
        "pastel_grass_side",
        "pastel_aurora_stone",
        "pastel_aurora_log",
        "pastel_aurora_log_top",
        "stripped_pastel_aurora_log",
        "stripped_pastel_aurora_log_top",
        "pastel_aurora_planks",
        "pastel_pink_leaves",
        "pastel_purple_leaves",
        "pastel_blue_leaves",
        "sapphire_ore",
        "rosalita_ore",
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
        "pastel_pink_leaves",
        "pastel_purple_leaves",
        "pastel_blue_leaves",
        "shadow_leaves"
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
        "dream_fluid_bucket"
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
                image.getWidth() == 128
                    && image.getHeight() == 128,
                "Block texture is not 128x128: "
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
                "tags/blocks/pastel_aurora_logs.json"
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
