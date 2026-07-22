# Inventário de fontes manuais — Rosalita

Fonte privada auditada: `.assets/New Assets/`. Esses arquivos pertencem ao
autor, permanecem inalterados e são copiados literalmente pelo script
`tools/generate_rosalita_textures.py` para os recursos Fabric.

## Porta e alçapão

| Fonte | Dimensão | Alpha observado | Mapeamento final | Uso |
| --- | --- | --- | --- | --- |
| `Blocks/Rosalita_Door_Bottom.png` | 16×16 | mínimo 97, máximo 255; três valores | `textures/block/rosalita_door_bottom.png` | metade inferior da porta |
| `Blocks/Rosalita_Door_Buttom.png` | 16×16 | mínimo 97, máximo 255; três valores | `textures/block/rosalita_door_top.png` | metade superior da porta; `Buttom` é o nome-fonte com erro |
| `Blocks/Rosalita_Trapdoor.png` | 16×16 | mínimo 97, máximo 255; três valores | `textures/block/rosalita_trapdoor.png` | alçapão fechado, aberto e item 3D |

Os valores intermediários de alpha confirmam transparência parcial. Porta e
alçapão usam, portanto, a render layer translúcida. Não há um PNG manual
separado de item para a porta nesta fonte; o item 1.20.1 usa diretamente a
textura manual da metade inferior, no formato `minecraft:item/generated` que
o carvalho usa para portas.

## Baús

| Nome original | Caminho-fonte | Dimensão | SHA-256 | Alpha | Finalidade | Nome final | Destino final |
| --- | --- | --- | --- | --- | --- | --- | --- |
| `Rosalita_Normal.png` | `entity/chest/Rosalita_Normal.png` | 64×64 | `acf1863da87e4c8bc11e018d65267f8b3de1198dbed496f78d23e9da94a50dbe` | binário, 0–255 | baú simples | `rosalita_normal.png` | `assets/chaoticd/textures/entity/chest/rosalita_normal.png` |
| `Rosalita_Normal_Left.png` | `entity/chest/Rosalita_Normal_Left.png` | 64×64 | `d366d53d36cd8618173d7134690b61b71a5d4f1604e624ffa1a97f458990fbf8` | binário, 0–255 | metade esquerda do baú duplo | `rosalita_normal_left.png` | `assets/chaoticd/textures/entity/chest/rosalita_normal_left.png` |
| `Rosalita_Normal_Right.png` | `entity/chest/Rosalita_Normal_Right.png` | 64×64 | `7ce9ea3222284b7274e64a25afd4a35110c0d9c5a06de7aba4ce5ab178ab49cb` | binário, 0–255 | metade direita do baú duplo | `rosalita_normal_right.png` | `assets/chaoticd/textures/entity/chest/rosalita_normal_right.png` |

O renderer escolhe `normal`, `normal_left` ou `normal_right` conforme o
`ChestType` real. As imagens não são usadas como textura de um cubo JSON nem
como item plano.

## Outros assets aplicados

- `Rosalita_Leaves.png` → `textures/block/rosalita_leaves.png`
- `Rosalita_Oak.png` → `textures/block/rosalita_log.png`
- `Rosalita_Oak_Top.png` → `textures/block/rosalita_log_top.png`
- `Rosalita_Planks.png` → `textures/block/rosalita_planks.png`
- `Rosalita_Sapling.png` → `textures/block/rosalita_sapling.png`

Nenhuma textura de crafting table específica foi fornecida nessa fonte. O
modelo Rosalita usa `rosalita_planks.png` em suas seis faces, sem fabricar uma
nova arte.
