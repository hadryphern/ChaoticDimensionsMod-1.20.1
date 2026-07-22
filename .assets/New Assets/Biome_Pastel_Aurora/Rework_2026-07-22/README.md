# Aurora block rework — 2026-07-22

This directory preserves the editable history of the Aurora block-family rework.

## Directory layout

- `Sources/`: original high-resolution generated artwork before the game-ready conversion.
- `Transparent_Sources/`: leaf artwork after explicit green-screen removal and alpha cleanup.
- `Final_Block_Textures/`: the exact 128×128 images copied into the active resource pack.

The previous active textures and their source sheets are preserved at:

```text
.assets/Removed Assets/2026-07-22_pre-aurora-block-rework/
```

## Active texture mapping

| Texture | Purpose |
| --- | --- |
| `pastel_aurora_log` | Bark used by log and wood |
| `pastel_aurora_log_top` | End grain used by log |
| `stripped_pastel_aurora_log` | Exposed wood used by stripped log and stripped wood |
| `stripped_pastel_aurora_log_top` | End grain used by stripped log |
| `pastel_aurora_planks` | Aurora planks |
| `pastel_pink_leaves` | Pink leaf canopy with real transparency |
| `pastel_purple_leaves` | Purple leaf canopy with real transparency |
| `pastel_blue_leaves` | Blue leaf canopy with real transparency |
| `pastel_grass` | Grass top |
| `pastel_grass_side` | Grass-to-soil transition |
| `pastel_soil` | Aurora soil and grass bottom |
| `pastel_aurora_stone` | Interior stone of the floating islands |
| `sapphire_ore` | Sapphire veins embedded in Aurora stone |
| `rosalita_ore` | Rosalita veins embedded in Aurora stone |

All final textures use one coherent resolution: 128×128 pixels. The leaf PNGs preserve true alpha;
the other textures are fully opaque. The bright-green matte from the old source sheets is not part of
the final assets.
