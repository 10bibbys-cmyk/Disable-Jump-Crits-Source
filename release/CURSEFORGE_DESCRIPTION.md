# Disable Jump Crits

**Remove vanilla jump critical hits without disabling attribute-based critical hits.**

**Disable Jump Crits** is a lightweight Fabric mod for **Minecraft 1.20.1**, developed for **Path of the Ascended** and modpacks that use their own critical-hit systems.

Vanilla Minecraft normally grants a critical hit when a player attacks while falling. This mod disables that specific airborne critical check, so jumping cannot bypass your pack's intended critical-hit progression.

## Features

- **Disables vanilla jump crits:** Falling attacks no longer receive the guaranteed vanilla critical-hit bonus.
- **Preserves modded critical hits:** Attribute-based critical chance and critical damage continue to be handled by their respective mods, including **Zenith Attributes Renewed**.
- **Zenith critical feedback:** Keeps Zenith crit sounds and electric-spark particles tied to successful damage events, avoiding feedback for rejected hits.
- **Minimal gameplay impact:** Does not change fall distance, movement, jumping, attack speed, normal melee damage, knockback or fall damage.
- **Lightweight:** No configuration, background scanning or tick-based processing.

Ranged attacks, spell critical hits and unrelated damage systems are not intentionally modified.

## Compatibility

- **Minecraft:** Java Edition 1.20.1
- **Mod Loader:** Fabric
- **Java:** 17+
- **Required dependency:** Zenith Attributes Renewed **1.0.3**
- **Configuration:** None

The Zenith compatibility code targets the internals of **Zenith Attributes Renewed 1.0.3**. Other versions have not been verified and may be incompatible.

This release is designed for both client and server. Install the same version on both sides when playing multiplayer.

## Installation

1. Install Fabric Loader for Minecraft 1.20.1.
2. Install **Zenith Attributes Renewed 1.0.3** and its required dependencies.
3. Place **Disable Jump Crits** in your `mods` folder.
4. Restart Minecraft or your server.

No configuration is needed. Vanilla jump crits are disabled automatically.

## Technical Details

The mod uses a targeted Mixin to suppress the vanilla airborne-critical flag inside `PlayerEntity.attack`. Additional Mixins handle Zenith's accepted-hit critical feedback.

It does not alter the player's actual fall distance, replace the combat system or change critical-hit attributes. Because some hooks are version-specific, compatibility with other Minecraft or Zenith releases is not guaranteed.

## Credits

**Developed for Path of the Ascended**, and shared as a standalone compatibility mod for other Minecraft 1.20.1 Fabric packs.

**AI-Assisted Development Disclosure:** AI-assisted tools were used during development and documentation. The mod has been reviewed and tested by its human developer.
