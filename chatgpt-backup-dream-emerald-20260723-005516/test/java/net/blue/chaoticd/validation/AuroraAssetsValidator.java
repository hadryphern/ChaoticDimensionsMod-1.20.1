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
 * Standalone packaging validator for the Aurora and Shadow block families.
 *
 * <p>The class keeps its original name because the Gradle task already points
 * to it, but it now validates assets belonging to both dimensions.</p>
 *
 * <p>Additional block textures are allowed. This prevents every future block
 * from breaking the build merely because the texture directory grew.</p>
 */
public final class AuroraAssetsValidator {
    private static final Path ROOT =
        Path.of("build/resources/main");

    private static final Path ASSETS =
        ROOT.resolve("assets/chaoticd");

    private static final Path DATA =
        ROOT.resolve("data/chaoticd");

    private static final Set<String> AURORA_BLOCKS = Set.of(
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
        "rosalita_ore"
    );

    private static final Set<String> SHADOW_BLOCKS = Set.of(
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

    private static final Set<String> ALL_REQUIRED_BLOCKS = Set.of(
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

    private static final Set<String> AURORA_BLOCK_TEXTURES = Set.of(
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
        "rosalita_ore"
    );

    private static final Set<String> SHADOW_BLOCK_TEXTURES = Set.of(
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

    private static final Set<String> ALL_REQUIRED_BLOCK_TEXTURES = Set.of(
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

    private static final Set<String> TRANSPARENT_LEAF_TEXTURES = Set.of(
        "pastel_pink_leaves",
        "pastel_purple_leaves",
        "pastel_blue_leaves",
        "shadow_leaves"
    );

    /**
     * Aurora already had translations in these four languages.
     */
    private static final List<String> AURORA_LANGUAGES = List.of(
        "pt_br",
        "en_us",
        "es_co",
        "es_mx"
    );

    /**
     * Shadow translations were initially authored in Portuguese and English.
     */
    private static final List<String> SHADOW_LANGUAGES = List.of(
        "pt_br",
        "en_us"
    );

    private AuroraAssetsValidator() {
    }

    public static void main(String[] args) throws IOException {
        check(
            Files.isRegularFile(ROOT.resolve("pack.mcmeta")),
            "Missing pack.mcmeta"
        );

        validateEveryJson();
        validateBlockCoverage();
        validateTextures();
        validateModelReferences();
        validateLanguages();
        validateRequiredTags();
        validateDeathTotemAssets();

        System.out.println(
            "AURORA/SHADOW ASSET VALIDATION PASSED: "
                + ALL_REQUIRED_BLOCKS.size()
                + " blocks, "
                + ALL_REQUIRED_BLOCK_TEXTURES.size()
                + " required 128x128 block textures, alpha, JSON, "
                + "loot tables, translations, tags and model references."
        );
    }

    /**
     * Parses every JSON resource so malformed data is detected before runtime.
     */
    private static void validateEveryJson() throws IOException {
        try (Stream<Path> files = Files.walk(ROOT)) {
            for (
                Path file : files
                    .filter(Files::isRegularFile)
                    .filter(
                        path ->
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

    /**
     * Every registered required block must have a blockstate, item model
     * and loot table.
     */
    private static void validateBlockCoverage() {
        for (String id : ALL_REQUIRED_BLOCKS) {
            requireFile(
                ASSETS.resolve("blockstates/" + id + ".json")
            );

            requireFile(
                ASSETS.resolve("models/item/" + id + ".json")
            );

            requireFile(
                DATA.resolve("loot_tables/blocks/" + id + ".json")
            );
        }
    }

    /**
     * Validates required textures without rejecting unrelated future textures.
     */
    private static void validateTextures() throws IOException {
        Path textureRoot =
            ASSETS.resolve("textures/block");

        check(
            Files.isDirectory(textureRoot),
            "Missing block texture directory: " + textureRoot
        );

        Set<String> actual = new LinkedHashSet<>();

        try (Stream<Path> files = Files.list(textureRoot)) {
            files
                .filter(path -> path.toString().endsWith(".png"))
                .map(
                    path ->
                        path.getFileName()
                            .toString()
                            .replaceFirst("\\.png$", "")
                )
                .sorted()
                .forEach(actual::add);
        }

        Set<String> missing =
            new LinkedHashSet<>(ALL_REQUIRED_BLOCK_TEXTURES);

        missing.removeAll(actual);

        check(
            missing.isEmpty(),
            "Missing required block textures: " + missing
        );

        /*
         * Additional textures are intentionally accepted.
         * This avoids breaking the validator whenever a new block family
         * is added to the mod.
         */
        Set<String> additional =
            new LinkedHashSet<>(actual);

        additional.removeAll(ALL_REQUIRED_BLOCK_TEXTURES);

        if (!additional.isEmpty()) {
            System.out.println(
                "Additional block textures detected and allowed: "
                    + additional
            );
        }

        for (String id : ALL_REQUIRED_BLOCK_TEXTURES) {
            validateTexture(textureRoot, id);
        }
    }

    private static void validateTexture(
        Path textureRoot,
        String id
    ) throws IOException {
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
            "Texture is not 128x128: "
                + file
                + " is "
                + image.getWidth()
                + "x"
                + image.getHeight()
        );

        int transparentPixels = 0;
        int brightGreenPixels = 0;

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int argb =
                    image.getRGB(x, y);

                int alpha =
                    argb >>> 24;

                int red =
                    argb >>> 16 & 0xff;

                int green =
                    argb >>> 8 & 0xff;

                int blue =
                    argb & 0xff;

                if (alpha == 0) {
                    transparentPixels++;
                }

                if (
                    alpha > 16
                        && green > 210
                        && red < 80
                        && blue < 80
                ) {
                    brightGreenPixels++;
                }
            }
        }

        if (TRANSPARENT_LEAF_TEXTURES.contains(id)) {
            double transparencyRatio =
                transparentPixels
                    / (double)(
                        image.getWidth()
                            * image.getHeight()
                    );

            check(
                transparencyRatio >= 0.10D
                    && transparencyRatio <= 0.65D,
                "Leaf alpha ratio outside 10%-65%: "
                    + id
                    + "="
                    + transparencyRatio
            );

            check(
                brightGreenPixels == 0,
                "Chroma-key green remained visible in "
                    + id
                    + ": "
                    + brightGreenPixels
                    + " pixels"
            );

            return;
        }

        check(
            transparentPixels == 0,
            "Opaque block texture contains transparent pixels: "
                + id
        );
    }

    /**
     * Checks every blockstate and model in the mod, not only Aurora/Shadow.
     */
    private static void validateModelReferences() throws IOException {
        Path blockstates =
            ASSETS.resolve("blockstates");

        try (Stream<Path> files = Files.list(blockstates)) {
            for (
                Path file : files
                    .filter(
                        path ->
                            path.toString().endsWith(".json")
                    )
                    .toList()
            ) {
                JsonElement root =
                    readJson(file);

                Set<String> models =
                    new LinkedHashSet<>();

                collectNamedStrings(
                    root,
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
                    .filter(
                        path ->
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
                            || !texture.startsWith("chaoticd:")
                    ) {
                        continue;
                    }

                    String local =
                        texture.substring(
                            "chaoticd:".length()
                        );

                    requireFile(
                        ASSETS.resolve(
                            "textures/" + local + ".png"
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

    private static void validateLanguages() throws IOException {
        /*
         * Preserve validation of the original Aurora translations.
         */
        for (String language : AURORA_LANGUAGES) {
            Path file =
                ASSETS.resolve(
                    "lang/" + language + ".json"
                );

            JsonObject translations =
                readJson(file).getAsJsonObject();

            for (String id : AURORA_BLOCKS) {
                check(
                    translations.has(
                        "block.chaoticd." + id
                    ),
                    "Missing "
                        + language
                        + " translation for "
                        + id
                );
            }

            check(
                translations.has(
                    "biome.chaoticd.aurora_biome"
                ),
                "Missing Aurora biome translation in "
                    + language
            );

            check(
                translations.has(
                    "dimension.chaoticd.aurora_dimension"
                ),
                "Missing Aurora dimension translation in "
                    + language
            );
        }

        /*
         * Shadow currently has Portuguese and English translations.
         */
        for (String language : SHADOW_LANGUAGES) {
            Path file =
                ASSETS.resolve(
                    "lang/" + language + ".json"
                );

            JsonObject translations =
                readJson(file).getAsJsonObject();

            for (String id : SHADOW_BLOCKS) {
                check(
                    translations.has(
                        "block.chaoticd." + id
                    ),
                    "Missing "
                        + language
                        + " Shadow translation for "
                        + id
                );
            }

            check(
                translations.has(
                    "item.chaoticd.death_totem"
                ),
                "Missing Death Totem translation in "
                    + language
            );

            check(
                translations.has(
                    "biome.chaoticd.shadow_biome"
                ),
                "Missing Shadow biome translation in "
                    + language
            );

            check(
                translations.has(
                    "dimension.chaoticd.shadow_dimension"
                ),
                "Missing Shadow dimension translation in "
                    + language
            );

            requireAdvancementTranslations(
                translations,
                language
            );
        }
    }

    private static void requireAdvancementTranslations(
        JsonObject translations,
        String language
    ) {
        List<String> advancements = List.of(
            "obtain_death_totem",
            "enter_aurora",
            "enter_shadow",
            "escape_shadow"
        );

        for (String advancement : advancements) {
            check(
                translations.has(
                    "advancement.chaoticd."
                        + advancement
                        + ".title"
                ),
                "Missing advancement title "
                    + advancement
                    + " in "
                    + language
            );

            check(
                translations.has(
                    "advancement.chaoticd."
                        + advancement
                        + ".description"
                ),
                "Missing advancement description "
                    + advancement
                    + " in "
                    + language
            );
        }
    }

    private static void validateRequiredTags() {
        requireFile(
            DATA.resolve(
                "tags/blocks/pastel_aurora_logs.json"
            )
        );

        requireFile(
            DATA.resolve(
                "tags/items/pastel_aurora_logs.json"
            )
        );

        requireFile(
            DATA.resolve(
                "tags/blocks/aurora_ore_replaceables.json"
            )
        );

        requireFile(
            DATA.resolve(
                "tags/blocks/shadow_logs.json"
            )
        );

        requireFile(
            DATA.resolve(
                "tags/items/shadow_logs.json"
            )
        );

        requireFile(
            ROOT.resolve(
                "data/minecraft/tags/blocks/logs.json"
            )
        );

        requireFile(
            ROOT.resolve(
                "data/minecraft/tags/blocks/logs_that_burn.json"
            )
        );

        requireFile(
            ROOT.resolve(
                "data/minecraft/tags/items/logs.json"
            )
        );

        requireFile(
            ROOT.resolve(
                "data/minecraft/tags/items/logs_that_burn.json"
            )
        );

        requireFile(
            ROOT.resolve(
                "data/minecraft/tags/blocks/planks.json"
            )
        );

        requireFile(
            ROOT.resolve(
                "data/minecraft/tags/items/planks.json"
            )
        );

        requireFile(
            ROOT.resolve(
                "data/minecraft/tags/blocks/leaves.json"
            )
        );

        requireFile(
            ROOT.resolve(
                "data/minecraft/tags/items/leaves.json"
            )
        );

        requireFile(
            ROOT.resolve(
                "data/minecraft/tags/blocks/mineable/axe.json"
            )
        );

        requireFile(
            ROOT.resolve(
                "data/minecraft/tags/blocks/mineable/shovel.json"
            )
        );

        requireFile(
            ROOT.resolve(
                "data/minecraft/tags/blocks/mineable/pickaxe.json"
            )
        );

        requireFile(
            ROOT.resolve(
                "data/fabric/tags/blocks/needs_tool_level_4.json"
            )
        );
    }

    private static void validateDeathTotemAssets() {
        requireFile(
            ASSETS.resolve(
                "models/item/death_totem.json"
            )
        );

        requireFile(
            ASSETS.resolve(
                "textures/item/death_totem.png"
            ),
            "Missing Death Totem PNG. Export the .aseprite file to: "
                + ASSETS.resolve(
                    "textures/item/death_totem.png"
                )
        );
    }

    private static JsonElement readJson(
        Path file
    ) throws IOException {
        try (
            Reader reader =
                Files.newBufferedReader(file)
        ) {
            JsonElement json =
                JsonParser.parseReader(reader);

            check(
                json != null && !json.isJsonNull(),
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
            element
                .getAsJsonArray()
                .forEach(
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
                    && entry.getValue().isJsonPrimitive()
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